import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/Service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string;
  password: string;

  constructor(private http: HttpClient, private router: Router, private authService: AuthServiceService) {}

  login() {
    const data = {
      email: this.email,
      password: this.password
    };

    this.http.post('http://localhost:8081/api/v1/login', data).subscribe((response: any) => {
      this.authService.setToken(response.token);
      this.router.navigate(['/dashboard']);
    });
  }
}
