import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../../User';
import { UiService } from '../../services/ui.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
})
export class AddUserComponent implements OnInit {
  username!: string;
  email!: string;
  showAddUser!: boolean;
  subscription: Subscription;

  @Output() onAddUser: EventEmitter<User> = new EventEmitter();

  constructor(private uiService: UiService) {
    this.subscription = this.uiService
      .onAddUser()
      .subscribe((value) => (this.showAddUser = value));
  }

  onSubmit() {
    if (!this.username || !this.email) {
      alert('Please insert valid data');
      return;
    }

    const newUser = {
      username: this.username,
      email: this.email,
      city: {},
    };

    // Emit the event
    this.onAddUser.emit(newUser);
    this.clearForm();

    // Close the form
    this.showAddUser = !this.showAddUser;
  }

  clearForm() {
    this.username = this.email = '';
  }

  ngOnInit(): void {}
}
