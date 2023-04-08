import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthServiceService {
  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private accessToken: string ="";

  constructor(private jwtHelper: JwtHelperService, private http: HttpClient) {}

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
    return !!token && !this.jwtHelper.isTokenExpired(token);
  }
}






