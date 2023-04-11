import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthServiceService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private accessToken: string ="";
  role: string | null = "";

  constructor(private jwtHelper: JwtHelperService, private http: HttpClient, private router: Router, private authService: AuthServiceService) {}

  // method to register a new user
  registerUser(user: any): any {
    const url = `http://localhost:8081/api/v1/auth/register`
    return this.http.post(url, user, { observe: 'response' }).subscribe(
      (response: HttpResponse<any>) => {
        console.log('Response status code:', response.status);
        const token = response.body ? response.body.token : null; // Check if response body is null
        console.log('Token:', token);
        // saving the token in local storage
        this.authService.setToken(token);
        // redirecting to the home page
        this.router.navigate(['/home']);
      },
      (error)=> {
        console.log(error)
        alert('Invalid Credentials');
      }
    )
  }
}
