import { Component, Directive, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserData } from 'src/app/interfaces/UserData';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null,
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService
  ) {}

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;

    // 1. Get the token
    this.authService.getToken(username, password).subscribe(
      (response) => {
        // Save the token in the local storage
        console.log('Response:');
        console.log(response);
        if (response.token) this.tokenStorage.saveToken(response.token);
        else throw Error('Received null token');

        // Save the user info in the local storage
        this.tokenStorage.saveUser(response);
        console.log('User info:');
        console.log(this.tokenStorage.getUser());
        // Login succeded
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        // Reload the page to update the status
        this.reloadPage();
      },
      (err) => {
        this.errorMessage = 'Incorrect username or password';
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }
}
