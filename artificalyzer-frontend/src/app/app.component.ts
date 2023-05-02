import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'artificalyzer-frontend';
  isUserLoggedIn: boolean = false;;

  ngOnInit(){
    this.isLoggedIn();
  }

  isLoggedIn(){
    if(localStorage.getItem("AUTH_TOKEN")){
      this.isUserLoggedIn = true;
    }else{
      this.isUserLoggedIn = false;
    }
  }
}

