import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { AuthServiceService } from 'src/app/Service/auth-service.service';
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
  role: string | null = '';
  appUser: any;
  cities: any;
  hospitalForm: FormGroup = new FormGroup({
    address: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    map: new FormControl('', [Validators.required]),
    city: new FormControl('', [Validators.required]),
    manager: new FormControl('', [Validators.required])
  });

  constructor(private fb: FormBuilder, private http: HttpClient, private authService: AuthServiceService) {}

  ngOnInit() {
    this.http.get<Hospital[]>('http://localhost:8081/api/v1/user/hospital').subscribe(hospitals => {
      this.hospitals = hospitals;
      this.role = this.authService.getrole();
    });
    this.http.get('http://localhost:8081/api/v1/admin/users').subscribe(appUser => {
      this.appUser = appUser;
      console.log(this.appUser);
    });
    this.http.get('http://localhost:8081/api/v1/admin/city').subscribe(city => {
      this.cities = city;
      console.log(this.cities);
    });
    this.hospitalForm = this.fb.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      map: ['', Validators.required],
      city: ['', Validators.required],
      manager: ['', Validators.required]
    });
  }

  onSubmit() {
    const formData = this.hospitalForm.value;
    const postData = {
      name: formData.name,
      address: formData.address,
      phone: formData.phone,
      email: formData.email,
      map: formData.map,
      city: formData.city,
      manager: formData.manager
    };
    this.http.post('http://localhost:8081/api/v1/admin/hospital', postData).subscribe(response => {
      this.hospitalForm.reset(); // Clear the form
      this.ngOnInit(); // Refresh the table
      console.log(response);
      // do something with the response
    });
  }
}

