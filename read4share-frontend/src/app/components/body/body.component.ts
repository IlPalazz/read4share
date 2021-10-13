import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { UiService } from '../../services/ui.service';
import { DataService } from '../../services/data.service';
import { User } from '../../User';
import { Book } from '../../Book';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css'],
})
export class BodyComponent implements OnInit {
  showUser: boolean = false;
  subscription: Subscription;
  users: User[] = [];
  books: Book[] = [];

  constructor(private uiService: UiService, private dataService: DataService) {
    // Set a subscription to the toggle
    this.subscription = this.uiService
      .onToggle()
      .subscribe((value) => (this.showUser = value));
  }

  ngOnInit(): void {
    // Load users from the DB
    this.dataService.getUsers().subscribe((users) => (this.users = users));
    // Load books from the DB
    this.dataService.getBooks().subscribe((books) => (this.books = books));
  }
}
