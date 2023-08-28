import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSidenav} from "@angular/material/sidenav";
import {BreakpointObserver} from "@angular/cdk/layout";
import {NavigationEnd, Router} from "@angular/router";
import {delay, filter} from "rxjs";
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import {ApiService} from "./api.service";
@UntilDestroy()
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'artificalyzer-frontend';
  isUserLoggedIn: boolean = false;
  user: any;

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  constructor(private observer: BreakpointObserver, private router: Router, private apiService: ApiService) {}

  ngAfterViewInit() {
    this.observer
      .observe(['(max-width: 800px)'])
      .pipe(delay(1), untilDestroyed(this))
      .subscribe((res) => {
        if (res.matches) {
          this.sidenav.mode = 'over';
          this.sidenav.close();
        } else {
          this.sidenav.mode = 'side';
          this.sidenav.open();
        }
      });

    this.router.events
      .pipe(
        untilDestroyed(this),
        filter((e) => e instanceof NavigationEnd)
      )
      .subscribe(() => {
        if (this.sidenav.mode === 'over') {
          this.sidenav.close();
        }
      });
  }

  ngOnInit(){
    this.isLoggedIn();
    this.getUserDetails();
  }

  getUserDetails(){
    this.apiService.getUserDetails()
      .subscribe((data) => {
        this.user = data;
      })
  }

  isLoggedIn(){
    this.isUserLoggedIn = !!localStorage.getItem("AUTH_TOKEN");
  }

  logOut(){
    localStorage.removeItem("AUTH_TOKEN")
    this.router.navigate(['/login'])
    window.location.reload();
  }

  navigateToChat(){
    this.router.navigate(['/chat'])
  }

  navigateToSentenceAnalysis(){
    this.router.navigate(['/sentence/statements'])
  }

  navigateToEditsDavinciAiModel(){
    this.router.navigate(['/edits-davinci-aimodel'])
  }
  navigateToTranslateSentence(){
    this.router.navigate(['/translate_sentence'])
  }

  navigateToImageGeneratingAiModel(){
    this.router.navigate(['/images-generating-aimodel'])
  }

  navigateToSentimentStatsPie(){
    this.router.navigate(['/moderation-score-aimodel'])
  }

  navigateToLogin(){
    this.router.navigate(['/login'])
  }

  navigateToRegister(){
    this.router.navigate(['/register'])
  }

}

