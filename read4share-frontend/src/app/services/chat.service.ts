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
    // // return this.http.get<ChatPreview[]>(API_URL + `/preview/${userId}`);
    let previews: ChatPreview[] = [
      {
        userName: 'test_user1',
        userId: '111111111',
        bookTitle: 'Titolo mooooolto lungo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user2',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
      {
        userName: 'test_user3',
        userId: '111111111',
        bookTitle: 'Titolo',
        bookCoverUrl:
          'http://books.google.com/books/content?id=J0iQDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
        advId: 2,
      },
    ];
    return of(previews);
  }
}
