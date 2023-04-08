import { HttpClient } from '@angular/common/http';
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
    return this.http.post(`http://localhost:8081/api/v1/auth/authenticate`, body).pipe(
      tap((response: any) => {
        this.accessToken = response;
        console.log(this.accessToken)
        console.log('testing service')
        localStorage.setItem('accessToken', this.accessToken);
      })
    );
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






