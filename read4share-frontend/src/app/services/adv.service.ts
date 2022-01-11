import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { AdvOverview } from '../interfaces/AdvOverview';
import { AdvDetails } from '../interfaces/AdvDetails';
import { HttpClient } from '@angular/common/http';
import { SearchBookResult } from '../interfaces/SearchBookResult';

const API_URL = 'http://localhost:8080/api/adv';

// const httpOptions = {
//   headers: new HttpHeaders({
//     'Content-Type': 'application/json',
//     'Access-Control-Allow-Origin': 'http://localhost:8080',
//   }),
// };

@Injectable({
  providedIn: 'root',
})
export class AdvService {
  constructor(private http: HttpClient) {}

  getLatest(size: number): Observable<AdvOverview[]> {
    return this.http.get<AdvOverview[]>(API_URL + `/latest?size=${size}`);
  }

  getBestRate(size: number): Observable<AdvOverview[]> {
    return this.http.get<AdvOverview[]>(API_URL + `/bestrate?size=${size}`);
  }

  getFree(size: number): Observable<AdvOverview[]> {
    return this.http.get<AdvOverview[]>(API_URL + `/free?size=${size}`);
  }

  getFreeDelivery(size: number): Observable<AdvOverview[]> {
    return this.http.get<AdvOverview[]>(API_URL + `/freedel?size=${size}`);
  }

  getAsNew(size: number): Observable<AdvOverview[]> {
    return this.http.get<AdvOverview[]>(API_URL + `/asnew?size=${size}`);
  }

  getByCatId(
    id: number,
    page: number,
    size: number
  ): Observable<AdvOverview[]> {
    return this.http.get<AdvOverview[]>(
      API_URL +
        `/cat?
    id=${id}
    &page=${page}
    &size=${size}`
    );
  }

  getDetails(advId: number): Observable<AdvDetails> {
    return this.http.get<AdvDetails>(API_URL + `/details/${advId}`);
  }

  searchBook(title: string, author: string): Observable<SearchBookResult[]> {
    let response: SearchBookResult[] = [
      {
        isbn: '1111111111111',
        title: 'Atomic Habits 1',
        author: 'James Clear',
        publDate: '2018',
        publisher: 'Avery',
        language: 'en',
        coverUrl:
          'http://books.google.com/books/content?id=XfFvDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api',
        avgRating: 4,
        category: 'Personal growth',
      },
      {
        isbn: '1111111111111',
        title: 'Atomic Habits 2',
        author: 'James Clear',
        publDate: '2018',
        publisher: 'Avery',
        language: 'en',
        coverUrl:
          'http://books.google.com/books/content?id=XfFvDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api',
        avgRating: 4,
        category: 'Personal growth',
      },
      {
        isbn: '1111111111111',
        title: 'Atomic Habits 3',
        author: 'James Clear',
        publDate: '2018',
        publisher: 'Avery',
        language: 'en',
        coverUrl:
          'http://books.google.com/books/content?id=XfFvDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api',
        avgRating: 4,
        category: 'Personal growth',
      },
      {
        isbn: '1111111111111',
        title: 'Atomic Habits 4',
        author: 'James Clear',
        publDate: '2018',
        publisher: 'Avery',
        language: 'en',
        coverUrl:
          'http://books.google.com/books/content?id=XfFvDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api',
        avgRating: 4,
        category: 'Personal growth',
      },
      {
        isbn: '1111111111111',
        title: 'Atomic Habits 5',
        author: 'James Clear',
        publDate: '2018',
        publisher: 'Avery',
        language: 'en',
        coverUrl:
          'http://books.google.com/books/content?id=XfFvDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api',
        avgRating: 4,
        category: 'Personal growth',
      },
    ];
    return of(response);
  }
}
