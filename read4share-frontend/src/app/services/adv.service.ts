import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { AdvOverview } from '../interfaces/AdvOverview';
import { AdvDetails } from '../interfaces/AdvDetails';
import { HttpClient } from '@angular/common/http';
import { SearchBookResult } from '../interfaces/SearchBookResult';
import { shareReplay } from 'rxjs/operators';

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
    return this.http
      .post<SearchBookResult[]>(API_URL + '/books', {
        title,
        author,
      })
      .pipe(shareReplay(1));
  }
}
