import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  roles?: string[];
  isLoggedIn: boolean = false;
  showAdminBoard = false;
  username?: string;

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      console.log('User details from app-component:');
      console.log(user);
      this.roles = user!.roles;
      console.log(this.roles);
      this.showAdminBoard = this.roles!.includes('ROLE_ADMIN');
      console.log(this.showAdminBoard);
      this.username = user!.username;
      console.log(user);
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    setTimeout(() => {
      this.router.navigate(['/home']);
    }, 1000);
    window.location.reload();
  }
}
