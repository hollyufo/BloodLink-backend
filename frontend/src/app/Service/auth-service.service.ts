import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthServiceService {
  private readonly JWT_TOKEN = 'JWT_TOKEN';

  constructor(private jwtHelper: JwtHelperService) {}

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






