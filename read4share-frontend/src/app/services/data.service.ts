import { Injectable } from '@angular/core';
import { User } from '../User';
import { Book } from '../Book';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  // HTTP Header Options for PUT/Post requests
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getUsers(): Observable<User[]> {
    // HTTP GET request for the users
    return this.http.get<User[]>(this.apiUrl + '/user/all');
  }

  getBooks(): Observable<Book[]> {
    // HTTP GET request for the books
    return this.http.get<Book[]>(this.apiUrl + '/book/all');
  }

  addUser(user: User): Observable<User> {
    // POST request to add a new user
    return this.http.post<User>(this.apiUrl + '/user/add', user, httpOptions);
  }
}
