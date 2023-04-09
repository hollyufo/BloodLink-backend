import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  appUser: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8081/api/v1/user/profile').subscribe(
      response => {
        this.appUser = response.appUser;
        console.log(this.appUser);
      },
      error => {
        console.log(error);
      }
    );
  }
}
