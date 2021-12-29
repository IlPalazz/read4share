import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { shareReplay } from 'rxjs/operators';
import { ChatPreview } from '../interfaces/ChatPreview';

const API_URL = 'http://localhost:8080/api/chat';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:8080',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  constructor(private http: HttpClient) {}

  getChatPreview(): Observable<ChatPreview[]> {
    return this.http.get<ChatPreview[]>(API_URL + `/preview`);
  }

  startChat(buyerId: string, advId: number): Observable<any> {
    return this.http
      .post<any>(
        API_URL + '/start',
        {
          buyerId,
          advId,
        },
        httpOptions
      )
      .pipe(shareReplay(1));
  }
}
