import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/api.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  addRegisterGroup: FormGroup = new FormGroup({});
  errorRegistration: string = "";
  successRegister: string = "";

  constructor(private formBuilder: FormBuilder,
    private apiService: ApiService,
    private router: Router) { }

  ngOnInit(): void {
    this.addRegisterGroup = this.formBuilder.group({
      'firstName': new FormControl('', [Validators.required]),
      'lastName': new FormControl('', [Validators.required]),
      'email': new FormControl('', [Validators.required]),
      'password': new FormControl('', [Validators.required]),
      'confirmPassword': new FormControl('', [Validators.required])
    });
  }

  onRegisterSubmit() {
    const values = this.addRegisterGroup.value;
  //   this.apiService.registerIn(values.firstName, values.lastName, values.email, values.password, values.confirmPassword)
  //     .subscribe(() => {
  //       console.log("TESTEST");
        
  //       this.router.navigate(['/login'])
  //     },
  //       (error: any) => {
  //         console.log(error)
  //         this.errorRegistration = error.error.message
  //       })
  // }
  this.apiService.registerIn(values.firstName, values.lastName, values.email, values.password, values.confirmPassword).subscribe({
    next:(res:any)=>{
      console.log(res);
      
      this.router.navigate(['/login'])
    },
    error:(err)=>{
      console.error(err)
      this.errorRegistration = err.error.message
    }
  })};
}
