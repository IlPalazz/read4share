import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { ChatPreview } from '../../../interfaces/ChatPreview';
import { ChatService } from '../../../services/chat.service';
import { UserData } from 'src/app/interfaces/UserData';

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
  message: string = '';
  binIndex?: number;

  constructor(
    private chatService: ChatService,
    private tokenStorageService: TokenStorageService
  ) {
    this.user = this.tokenStorageService.getUser();
  }

  ngOnInit(): void {
    // TODO: Implement Auth guard

    // Get userId
    if (this.user == null) {
      console.log('Error: User is null');
      return;
    }

    this.chatPreviews = this.chatService.getChatPreview();
  }

  onSendMessage() {
    console.log(this.message);
  }

  onSelectChat(index: number, chatPreview: ChatPreview) {
    this.selectedChatIndex = index;
    // TODO: Websockets call to get all messages
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
}
