import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/Service/auth-service.service';
import { RegisterService } from 'src/app/Service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {



  email!: string;
  password!: string;
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router, private registerService: RegisterService) {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      birthDate: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', Validators.required],
      phone: ['', Validators.required],
      govId: ['', Validators.required],
    });
  }
  onSubmit() {
    this.registerService.registerUser(this.loginForm.value);
  }
}
