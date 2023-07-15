import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChatGptComponent } from './chatGpt-aimodel/components/chat-gpt/chat-gpt.component';
import { LoginComponent } from './login/components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './register/components/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from "@angular/material/button";
import { SentenceStatementsComponent } from './sentence-statements/sentence-statements.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { AboutPageComponent } from './about-page/about-page.component';
import { HelpPageComponent } from './help-page/help-page.component';
import { RecoverAccountComponent } from './recover-account/recover-account.component';

@NgModule({
  declarations: [
    AppComponent,
    ChatGptComponent,
    LoginComponent,
    RegisterComponent,
    SentenceStatementsComponent,
    HomePageComponent,
    ProfilePageComponent,
    AboutPageComponent,
    HelpPageComponent,
    RecoverAccountComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
