import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {ApiService} from 'src/app/api.service';
import {map} from "rxjs";
import {Location} from "@angular/common";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private apiService: ApiService, private router: Router,
              private location: Location) {
  }

  handleSubmit() {
    this.apiService.logIn(this.email, this.password)
      .subscribe((response: any) => {
        localStorage.setItem('AUTH_TOKEN', response.token);
        location.href = "/"
      },
        (error: any) => {
        this.errorMessage = "Failed to login."
        });
  }

}
