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
    //return this.http.get<ChatPreview[]>(API_URL + `/preview`);
    let previews: ChatPreview[] = [
      {
        recipientUsername: 'test_user1_lungooooooooo',
        recipientId: '111111111',
        bookTitle: 'Titolo mooooolto lungo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user2',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        recipientUsername: 'test_user3',
        recipientId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
    ];
    return of(previews);
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
