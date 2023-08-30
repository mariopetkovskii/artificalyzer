import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {first, map} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  endpointUrl: string = 'http://localhost:10101/rest';
  httpOptions = {
    headers: this.getAuthHeaders()
  };

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('AUTH_TOKEN');
    return new HttpHeaders({
      'Authorization': 'Bearer ' + token
    });
  }

  constructor(private httpClient: HttpClient) {
  }

  logIn(email: string, password: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'text/plain',
        'Authorization': 'Basic ' + btoa(email + ':' + password)
      })
    };

    return this.httpClient.post(this.endpointUrl + "/user/login", {}, httpOptions)
  }

  getUserDetails(){
    const httpOptions = {
      headers: this.getAuthHeaders()
    };

    return this.httpClient.get(this.endpointUrl + "/user/details", httpOptions)
  }

  changeProfileSettings(firstName: string, lastName: string, email: string, password: string){
    let json = {
      "firstName": firstName,
      "lastName": lastName,
      "email": email,
      "password": password
    }

    const httpOptions = {
      headers: this.getAuthHeaders()
    };

    return this.httpClient.post(this.endpointUrl + "/user/edit-account", json, httpOptions);
  }

  registerIn(firstName: string, lastName: string, email: string, password: string, confirmPassword: string) {
    let json = {
      "firstName": firstName,
      "lastName": lastName,
      "email": email,
      "password": password,
      "confirmPassword": confirmPassword
    }

    return this.httpClient.post(this.endpointUrl + "/user/register", json);
  }

  analyzeSentence(sentence: string) {
    let json = {
      "sentence": sentence
    }

    const httpOptions = {
      headers: this.getAuthHeaders()
    };

    return this.httpClient.post(this.endpointUrl + "/model/sentence/analysis", json, httpOptions)
  }

  instructionModelEditsPost(text: string,
                            instruction: string){

    let json = {
      "inputText": text,
      "instruction": instruction
    }

    const httpOptions = {
      headers: this.getAuthHeaders()
    };

    return this.httpClient.post(this.endpointUrl + "/aimodels/edits/post", json, httpOptions)
  }

  generateImage(prompt: string, size: string){

    let json = {
      "prompt": prompt,
      "size": size
    }

    const httpOptions = {
      headers: this.getAuthHeaders()
    };

    return this.httpClient.post(this.endpointUrl + "/aimodels/images/generate", json, httpOptions)
  }

  sendRecoveryAccountPassword(email: string){
    let json = {
      "email": email
    }

    return this.httpClient.post(this.endpointUrl + "/user/recovery-password/sendMail", json)
  }

  changeRecoveryAccountPassword(password: string, confirmPassword: string, token: string | null){
    let json = {
      "newPassword": password,
      "confirmNewPassword": confirmPassword,
      "token": token
    }

    return this.httpClient.post(this.endpointUrl + "/user/recovery-password", json)
  }

  getModerationScore(input:any){
    let json={
      "input":input
    }

    return this.httpClient.post(this.endpointUrl+"/aimodels/moderations",json,this.httpOptions);
  }

  getMyEdits(pageNo:any){
    const httpOptions = {
      headers: this.getAuthHeaders()
    };
    return this.httpClient.get(this.endpointUrl + "/models/editsuser/get?pageNo="+pageNo, httpOptions);
  }

  
  getMyImages(pageNo:any){
    const httpOptions = {
      headers: this.getAuthHeaders()
    };
    return this.httpClient.get(this.endpointUrl + "/models/imagesuser/get", httpOptions);
  }

  getMyScores(pageNo:any){
    const httpOptions = {
      headers: this.getAuthHeaders()
    };
    return this.httpClient.get(this.endpointUrl + "/models/moderations/get", httpOptions);
  }


}
