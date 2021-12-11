import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    passwordCheck: null,
  };
  isRegistered = false;
  isRegistrationFailed: boolean = false;
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
    console.log('Ci entro');
    const { username, email, password, passwordCheck } = this.form;
    this.authService.registerUser(username, email, password).subscribe(
      (response) => {
        console.log(response);
        this.isRegistrationFailed = false;
        this.isRegistered = true;
      },
      (err) => {
        console.log(err);
        this.errorMessage = err.error.message;
        this.isRegistrationFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }
}
