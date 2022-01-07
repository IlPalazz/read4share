import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { shareReplay } from 'rxjs/operators';
import { UserData } from '../interfaces/UserData';

const API_URL = 'http://localhost:8080/api/auth';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:8080',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  /**
   * Send the credentials to the user and return the response
   * @param username Username
   * @param password Password
   * @returns Authentication response
   */
  login(username: string, password: string): Observable<any> {
    return this.http
      .post<any>(
        API_URL + '/login',
        {
          username,
          password,
        },
        httpOptions
      )
      .pipe(shareReplay(1));
  }

  /**
   * Send a request to obtain information about a specific user
   * @returns User's data (if the token is valid)
   */
  getUserData(): Observable<UserData> {
    return this.http.get<UserData>(API_URL + '/details'); //.pipe(shareReplay(1));
  }

  /**
   * Send a request to register a new user
   * @param username Username
   * @param email E-mail
   * @param password Password
   * @returns HTTP request status
   */
  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(
      API_URL + '/register',
      {
        username,
        email,
        password,
      },
      httpOptions
    );
  }
}
