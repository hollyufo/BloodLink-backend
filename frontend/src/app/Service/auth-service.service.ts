import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthServiceService {
  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private accessToken: string ="";
  role: string | null = "";

  constructor(private jwtHelper: JwtHelperService, private http: HttpClient, private router: Router) {}

  login(username: string, password: string): any {
    const body =
    {
      "email" : username,
      "password" : password
    }
    console.log(body)
    const url = `http://localhost:8081/api/v1/auth/authenticate`
    return this.http.post(url, body, { observe: 'response' }).subscribe(
      (response: HttpResponse<any>) => {
        console.log('Response status code:', response.status);
        const token = response.body ? response.body.token : null; // Check if response body is null
        console.log('Token:', token);
        // saving the token in local storage
        this.setToken(token);
        // redirecting to the home page
        this.router.navigate(['/home']);
      },
      (error)=> {
        console.log(error)
        alert('Invalid Credentials');
      }
    )
  }


  setToken(token: string | null) {
    if (token) {
      localStorage.setItem(this.JWT_TOKEN, token);
    }
  }

  getToken(): string | null {
    return localStorage.getItem(this.JWT_TOKEN);
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    // if token is expired, remove it from local storage
    if (this.jwtHelper.isTokenExpired(token)) {
      localStorage.removeItem(this.JWT_TOKEN);
    }
    return !!token && !this.jwtHelper.isTokenExpired(token);
  }

  getrole(): string | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      return decodedToken.authorities[0].authority;
    }
    return null;
  }
}






