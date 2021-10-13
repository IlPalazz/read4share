import { Component, OnInit } from '@angular/core';
import { UiService } from '../../services/ui.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  showUser: boolean = false;
  subscription: Subscription;

  constructor(private uiService: UiService) {
    // Set a subscription to the toggle
    this.subscription = this.uiService
      .onToggle()
      .subscribe((value) => (this.showUser = value));
  }

  ngOnInit(): void {}

  toggleUserBook(): void {
    this.uiService.toggleUserBook();
  }
}
