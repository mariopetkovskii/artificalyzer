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

@NgModule({
  declarations: [
    AppComponent,
    ChatGptComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
