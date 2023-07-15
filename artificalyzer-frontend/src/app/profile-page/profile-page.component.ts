import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ApiService} from "../api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent implements OnInit{
  user: any;
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  password: string = "";

  constructor(private formBuilder: FormBuilder,
              private apiService: ApiService,
              private router: Router){}

  ngOnInit(): void {
    this.getUserDetails();
  }

  getUserDetails(){
    this.apiService.getUserDetails()
      .subscribe((data) => {
        this.user = data;
        this.firstName = this.user.firstName;
        this.lastName = this.user.lastName;
        this.email = this.user.email;
      })
  }

  onProfileChangeSubmit(){
    this.apiService.changeProfileSettings(this.firstName, this.lastName, this.email, this.password)
      .subscribe(() => {
        window.location.reload();
      })
  }
}
