import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Router } from '@angular/router';

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
  isLoginFailed = false;
  errorMessage = '';

  constructor(
    private authService: AuthService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // If the user is logged in redirect to home
    if (!!this.tokenStorageService.getToken()) this.router.navigate(['/home']);
  }

  onSubmit(): void {
    const { username, password } = this.form;

    // Get the token
    this.authService.login(username, password).subscribe(
      (response) => {
        // Save the token in the local storage
        if (response.token) this.tokenStorageService.saveToken(response.token);
        else throw Error('Received null token');
        // Save the user info in the local storage
        this.tokenStorageService.saveUser(response);
        // Login succeded
        this.isLoginFailed = false;
        localStorage.setItem('redirectToHome', 'true');
        // Reload the page to update the status
        window.location.reload();
      },
      (err) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
}
