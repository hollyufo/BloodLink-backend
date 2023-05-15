import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './Components/login/login.component';
import { HomeComponent } from './Components/home/home.component';
import { JwtHelperService, JwtModule } from '@auth0/angular-jwt';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './interceptor/AuthInterceptor';
import { HeaderComponent } from './Components/Header/header.component';
import { PostsComponent } from './Components/posts/posts.component';
import { LandingpageComponent } from './Components/landingpage/landingpage.component';
import { DonationsComponent } from './Components/donations/donations.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { HospitalsComponent } from './Components/hospitals/hospitals.component';
import { ManagerdonationComponent } from './Components/managerdonation/managerdonation.component';
import { RegisterComponent } from './Components/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    PostsComponent,
    LandingpageComponent,
    DonationsComponent,
    ProfileComponent,
    HospitalsComponent,
    ManagerdonationComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('accessToken');
        },
        allowedDomains: ['localhost:8081'],
        disallowedRoutes: []
      }
    })
  ],
  providers: [
    JwtHelperService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
