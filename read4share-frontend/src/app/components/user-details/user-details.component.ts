import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserData } from 'src/app/interfaces/UserData';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css'],
})
export class UserDetailsComponent implements OnInit {
  user?: UserData;

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.tokenStorageService.getToken() == null)
      this.router.navigate(['/home']);

    this.user = this.tokenStorageService.getUser()!;
  }

  onLogout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
