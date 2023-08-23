import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatGptComponent } from './chatGpt-aimodel/components/chat-gpt/chat-gpt.component';
import { LoginComponent } from './login/components/login/login.component';
import { RegisterComponent } from './register/components/register/register.component';
import {SentenceStatementsComponent} from "./sentence-statements/sentence-statements.component";
import {ProfilePageComponent} from "./profile-page/profile-page.component";
import {AboutPageComponent} from "./about-page/about-page.component";
import {RecoverAccountComponent} from "./recover-account/recover-account.component";
import {EditsAimodelComponent} from "./edits-aimodel/edits-aimodel.component";
import {ImageAimodelComponent} from "./image-aimodel/image-aimodel.component";
import {ModerationScoreAimodelComponent} from "./moderation-score-aimodel/moderation-score-aimodel.component";

const routes: Routes = [
  {  path: 'chat', component: ChatGptComponent },
  {  path: 'login', component: LoginComponent},
  {  path: 'register', component: RegisterComponent},
  {  path: 'sentence/statements', component: SentenceStatementsComponent},
  {  path: 'profile', component: ProfilePageComponent},
  {  path: 'about', component: AboutPageComponent},
  {  path: 'home', component: AboutPageComponent},
  {  path: 'forgot-change-password', component: RecoverAccountComponent},
  {  path: 'edits-davinci-aimodel', component: EditsAimodelComponent},
  {  path: 'images-generating-aimodel', component: ImageAimodelComponent},
  {  path: 'moderation-score-aimodel', component: ModerationScoreAimodelComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
