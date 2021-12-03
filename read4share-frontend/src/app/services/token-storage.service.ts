import { Injectable } from '@angular/core';
import { User } from '../interfaces/UserData';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root',
})
/*
 Service that manages token and user information (username,  email, roles) inside Browser’s Session Storage
 */
export class TokenStorageService {
  constructor() {}

  /**
   * Clear the local storage (remove both token and user info)
   */
  signOut(): void {
    window.sessionStorage.clear();
  }

  /**
   * Save the received token inside the local storage
   * @param token Json Web Token
   */
  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  /**
   * Return the token saved in the local storage
   * @returns Auth token, null if not present
   */
  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  /**
   * Save the info of a particular User inside the local storage
   * @param user Interface containing the user info
   */
  public saveUser(user: User): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  /**
   * Return the user info saved in the local storage
   * @returns User info, null if not present
   */
  public getUser(): User | null {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return null;
  }
}
