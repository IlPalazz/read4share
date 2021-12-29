import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { ChatPreview } from '../interfaces/ChatPreview';

const API_URL = 'http://localhost:8080/api/chat';

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  constructor(private http: HttpClient) {}

  getChatPreview(userId: string): Observable<ChatPreview[]> {
    return this.http.get<ChatPreview[]>(API_URL + `/preview/${userId}`);
  }
}
