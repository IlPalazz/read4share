import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UiService {
  private showUser: boolean = false;
  private subject = new Subject<any>();
  constructor() {}

  toggleUserBook(): void {
    // Toggle showUser
    this.showUser = !this.showUser;
    // Pass the current value of showUser
    this.subject.next(this.showUser);
  }

  onToggle(): Observable<any> {
    return this.subject.asObservable();
  }
}
