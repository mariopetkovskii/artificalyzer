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
import { EditsAimodelComponent } from './edits-aimodel/edits-aimodel.component';
import { ImageAimodelComponent } from './image-aimodel/image-aimodel.component';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatFormFieldModule} from "@angular/material/form-field";
import { ModerationScoreAimodelComponent } from './moderation-score-aimodel/moderation-score-aimodel.component';
import {PieChartModule} from "@swimlane/ngx-charts";
import { TranslateSentenceComponent } from './translate-sentence/translate-sentence.component';
import { MyEditsComponent } from './my-edits/my-edits.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { NzPaginationModule } from 'ng-zorro-antd/pagination';

import { NzTableModule } from 'ng-zorro-antd/table';
import { MyImagesComponent } from './my-images/my-images.component';
import { MyModerationScoreComponent } from './my-moderation-score/my-moderation-score.component';

registerLocaleData(en);

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
    EditsAimodelComponent,
    ImageAimodelComponent,
    ModerationScoreAimodelComponent,
    TranslateSentenceComponent,
    MyEditsComponent,
    MyImagesComponent,
    MyModerationScoreComponent,
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
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
    PieChartModule,
    NzPaginationModule,
    NzTableModule,
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
