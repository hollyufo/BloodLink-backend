import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
interface Hospital {
  id: number;
  name: string;
  address: string;
  phone: string;
  email: string;
  image: string;
  map: string;
  city: {
    id: number;
    name: string;
  };
  manager: {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
    city: {
      id: number;
      name: string;
    };
  };
}
@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})


export class HospitalsComponent implements OnInit {
  hospitals: Hospital[] | undefined;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Hospital[]>('http://localhost:8081/api/v1/user/hospital').subscribe(hospitals => {
      this.hospitals = hospitals;
    });
  }
}
