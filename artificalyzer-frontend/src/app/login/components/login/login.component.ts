import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private apiService: ApiService, private router: Router) {}

  handleSubmit() {
    this.apiService.logIn(this.email, this.password)
    .subscribe((response: any) => {
      localStorage.setItem('AUTH_TOKEN', response);
      console.log(response);
    });
}

}
