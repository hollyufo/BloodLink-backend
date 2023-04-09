import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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
  selector: 'app-managerdonation',
  templateUrl: './managerdonation.component.html',
  styleUrls: ['./managerdonation.component.css']
})
export class ManagerdonationComponent {
  donations: any[] | undefined;
  appUser: any;
  hospitals: Hospital[] | undefined;
  role: string | null = '';
  donationForm: FormGroup = new FormGroup({
    donor: new FormControl('', [Validators.required]),
    hospital: new FormControl('', [Validators.required]),
    date: new FormControl('', [Validators.required])
  });
  constructor(private fb: FormBuilder, private http: HttpClient, private authService: AuthServiceService) { }

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8081/api/v1/manager/donations')
      .subscribe(data => {
        this.donations = data;
        console.log(this.donations);
      });
      this.http.get('http://localhost:8081/api/v1/admin/users').subscribe(appUser => {
      this.appUser = appUser;
      console.log(this.appUser);
    });
    this.http.get<Hospital[]>('http://localhost:8081/api/v1/user/hospital').subscribe(hospitals => {
      this.hospitals = hospitals;
      this.role = this.authService.getrole();
    });
  }

  onSubmit() {
    const formData = this.donationForm.value;
    console.log(formData);
    const postData = {
      donor: formData.donor,
      hospital: formData.hospital,
      date: formData.date
    };
    this.http.post('http://localhost:8081/api/v1/manager/donations', postData).subscribe(responseData => {
      console.log(responseData);
      this.ngOnInit();
      this.donationForm.reset();
    } );
  }

}
