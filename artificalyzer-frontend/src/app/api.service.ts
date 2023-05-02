import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { first, map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

    endpointUrl: string = 'http://localhost:8081/rest';

 constructor(private httpClient: HttpClient) {}

 logIn(email: string, password: string){
     const httpOptions = {
         headers: new HttpHeaders({
           'Content-Type': 'text/plain',
           'Authorization': 'Basic ' + btoa(email + ':' + password)
        })
    };

    return this.httpClient.post(this.endpointUrl + "/user/login", {}, httpOptions)
 }

 registerIn(firstName: string, lastName: string, email: string, password: string, confirmPassword: string ){
    let json = {
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "password": password,
        "confirmPassword": confirmPassword
      }

      return this.httpClient.post(this.endpointUrl + "/user/register", json);
 }

}
