import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'artificalyzer-frontend';
  isUserLoggedIn: boolean = false;

  ngOnInit(){
    this.isLoggedIn();
  }

  isLoggedIn(){
    this.isUserLoggedIn = !!localStorage.getItem("AUTH_TOKEN");
  }

  logOut(){
    localStorage.removeItem("AUTH_TOKEN")
  }
}

