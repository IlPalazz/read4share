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
  selectedChat = {
    userId: null,
    userName: '',
    advId: null,
  };
  message: string = '';

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

    this.chatPreviews = this.chatService.getChatPreview(this.user.id);
  }

  onSendMessage() {
    console.log(this.message);
  }

  onSelectChat(index: number, chatPreview: ChatPreview) {
    this.selectedChatIndex = index;
    // TODO: Websockets call to get all messages
  }
}
