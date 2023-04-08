import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private router: Router) {}
  intercept(request: HttpRequest<any>, next: HttpHandler) {
    const authToken = localStorage.getItem('JWT_TOKEN');
    // Check if the request is for the login endpoint
    if (request.url.includes('login')) {
      return next.handle(request);
    }
    if (authToken) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${authToken}`
        }
      });
    }
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401) {
          // Unauthorized, token may be expired or invalid
          localStorage.removeItem('authToken');
          this.router.navigate(['/login']);
        }
        return throwError(error);
      })
    );
  }
}
