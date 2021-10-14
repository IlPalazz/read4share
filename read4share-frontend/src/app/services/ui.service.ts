import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UiService {
  private showUser: boolean = false;
  private showAddUser: boolean = false;
  private userBookSubj = new Subject<any>();
  private showFormSubj = new Subject<any>();

  constructor() {}

  toggleUserBook(): void {
    // Toggle showUser
    this.showUser = !this.showUser;
    // Pass the current value of showUser
    this.userBookSubj.next(this.showUser);
  }

  onToggle(): Observable<any> {
    return this.userBookSubj.asObservable();
  }

  toggleAddUser(): void {
    this.showAddUser = !this.showAddUser;
    this.showFormSubj.next(this.showAddUser);
  }

  onAddUser(): Observable<any> {
    return this.showFormSubj.asObservable();
  }
}
