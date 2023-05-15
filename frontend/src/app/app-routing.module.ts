import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { HomeComponent } from './Components/home/home.component';
import { LandingpageComponent } from './Components/landingpage/landingpage.component';
import { AuthGuard } from './Guard/Auth/auth.guard';
import { DonationsComponent } from './Components/donations/donations.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { HospitalsComponent } from './Components/hospitals/hospitals.component';
import { ManagerdonationComponent } from './Components/managerdonation/managerdonation.component';
import { RegisterComponent } from './Components/register/register.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {path: 'register', component: RegisterComponent},
  { path: 'home', component: LandingpageComponent, canActivate: [AuthGuard] },
  { path: 'donation', component: DonationsComponent, canActivate: [AuthGuard] },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
  { path: 'hospitals', component: HospitalsComponent, canActivate: [AuthGuard]},
  { path: 'makedonation', component: ManagerdonationComponent, canActivate: [AuthGuard] }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
