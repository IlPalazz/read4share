import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { ChatPreview } from '../../../interfaces/ChatPreview';
import { ChatService } from '../../../services/chat.service';
import { UserData } from 'src/app/interfaces/UserData';
import { Chat } from 'src/app/interfaces/Chat';
import { Client } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { Location } from '@angular/common';

export interface SendMessage {
  senderId: string;
  recipientId: string;
  advId: number;
  text: string;
}

@Component({
  selector: 'app-chat-overview',
  templateUrl: './chat-overview.component.html',
  styleUrls: ['./chat-overview.component.css'],
})
export class ChatOverviewComponent implements OnInit {
  chatPreviews?: Observable<ChatPreview[]>;
  user!: UserData | null;
  selectedChatIndex?: number;
  selectedChat?: ChatPreview;
  hoverChat?: ChatPreview;
  text: string = '';
  binIndex?: number;

  // Websocket variables
  messages: Chat[] = [];
  private client!: Client;
  connected: boolean = false;
  chatHistory: any;
  chatIncomingMess: any;

  constructor(
    private chatService: ChatService,
    private tokenStorageService: TokenStorageService,
    private location: Location
  ) {
    this.user = this.tokenStorageService.getUser();
  }

  ngOnInit(): void {
    // TODO: Implement Auth guard

    this.chatPreviews = this.chatService.getChatPreview();

    // Get userId
    if (this.user == null) {
      console.log('Error: User is null');
      return;
    }

    // Websockets initialization
    this.websocketInit();
    this.connect();
  }

  websocketInit(): void {
    console.log('Websocket init');
    this.client = new Client();
    //we assign the Sock js to Stomp
    this.client.webSocketFactory = () => {
      return new SockJS('http://localhost:8080/chat-websocket');
    };

    this.client.onConnect = (frame) => {
      console.log('Connected : ' + this.client.connected + ' : ' + frame);
      this.connected = true;
    };

    this.client.onDisconnect = (frame) => {
      console.log('Disconnected : ' + !this.client.connected + ' : ' + frame);
      this.connected = false;
    };
  }

  connect(): void {
    this.client.activate();
  }
  disconnect(): void {
    this.client.deactivate();
  }

  unsubscribe(): void {
    this.messages = [];
    if (this.chatHistory) this.chatHistory.unsubscribe();

    if (this.chatIncomingMess) this.chatIncomingMess.unsubscribe();
  }

  onSelectChat(index: number, chatPreview: ChatPreview) {
    this.selectedChatIndex = index;
    this.selectedChat = chatPreview;

    // Unsubscribe from previous chat
    this.unsubscribe();

    // Check if the user is either the seller or the buyer
    let advId = this.selectedChat.advId;
    let sellerId = this.selectedChat.sellerId;
    let buyerId = '';

    if (this.user?.id === sellerId) {
      buyerId = this.selectedChat.recipientId;
    } else {
      buyerId = this.user!.id;
    }

    // Subscribe to get chat history
    this.chatHistory = this.client.subscribe(
      `/app/sub/${advId}/${sellerId}/${buyerId}`,
      (history) => {
        console.log('Subscribed: ' + history.body);
        this.messages = JSON.parse(history.body) as Chat[];
      }
    );

    // Subscribe to receive incoming messages
    this.chatIncomingMess = this.client.subscribe(
      `/chats/message/${advId}/${sellerId}/${buyerId}`,
      (mess) => {
        console.log('Received message: ' + mess.body);
        this.messages.push(JSON.parse(mess.body) as Chat);
      }
    );
  }

  onSendMessage() {
    if (this.selectedChat == null || this.text === '') return;

    // Create message payload
    let message: SendMessage = {
      senderId: this.user!.id,
      recipientId: this.selectedChat.recipientId,
      advId: this.selectedChat.advId,
      text: this.text,
    };

    // Check if the user is either the seller or the buyer
    let advId = this.selectedChat.advId;
    let sellerId = this.selectedChat.sellerId;
    let buyerId = '';

    if (this.user?.id === sellerId) {
      buyerId = this.selectedChat.recipientId;
    } else {
      buyerId = this.user!.id;
    }

    console.log('Message:' + JSON.stringify(message));
    //Publish the new message
    this.client.publish({
      destination: `/app/send/${advId}/${sellerId}/${buyerId}`,
      body: JSON.stringify(message),
    });
    // this.client.publish({
    //   destination: `/app/teststring`,
    //   body: JSON.stringify(message),
    // });

    // Clear the text
    this.text = '';
  }

  showBin(index: number, chatPreview: ChatPreview) {
    this.binIndex = index;
    this.hoverChat = chatPreview;
  }

  hideBin() {
    this.binIndex = undefined;
    this.hoverChat = undefined;
  }

  onDeleteChat() {
    // Disconnect from websocket
    this.unsubscribe();

    if (this.hoverChat == null) return;
    this.chatService
      .deleteChat(
        this.user!.id,
        this.hoverChat.recipientId,
        this.hoverChat.advId
      )
      .subscribe(
        () => {
          window.location.reload();
        },
        (err) => {
          console.log(err.error.message);
        }
      );
  }

  onBack() {
    this.location.back();
  }
}
