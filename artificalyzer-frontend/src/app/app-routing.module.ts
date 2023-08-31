import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatGptComponent } from './chatGpt-aimodel/components/chat-gpt/chat-gpt.component';
import { LoginComponent } from './login/components/login/login.component';
import { RegisterComponent } from './register/components/register/register.component';
import { SentenceStatementsComponent } from "./sentence-statements/sentence-statements.component";
import { ProfilePageComponent } from "./profile-page/profile-page.component";
import { AboutPageComponent } from "./about-page/about-page.component";
import { RecoverAccountComponent } from "./recover-account/recover-account.component";
import { EditsAimodelComponent } from "./edits-aimodel/edits-aimodel.component";
import { ImageAimodelComponent } from "./image-aimodel/image-aimodel.component";
import { ModerationScoreAimodelComponent } from "./moderation-score-aimodel/moderation-score-aimodel.component";
import { TranslateSentenceComponent } from "./translate-sentence/translate-sentence.component";
import { MyEditsComponent } from './my-edits/my-edits.component';
import { MyImagesComponent } from './my-images/my-images.component';
import { MyModerationScoreComponent } from './my-moderation-score/my-moderation-score.component';
import { MySentimentAnalysisComponent } from './my-sentiment-analysis/my-sentiment-analysis.component';
import {MytranslateSentencesComponent} from './mytranslate-sentences/mytranslate-sentences.component';


const routes: Routes = [
  { path: 'chat', component: ChatGptComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'sentence/statements', component: SentenceStatementsComponent },
  { path: 'profile', component: ProfilePageComponent },
  { path: 'about', component: AboutPageComponent },
  { path: 'home', component: AboutPageComponent },
  { path: 'forgot-change-password', component: RecoverAccountComponent },
  { path: 'edits-davinci-aimodel', component: EditsAimodelComponent },
  { path: 'images-generating-aimodel', component: ImageAimodelComponent },
  { path: 'moderation-score-aimodel', component: ModerationScoreAimodelComponent },
  { path: 'translate_sentence', component: TranslateSentenceComponent },
  { path: 'my-edits', component: MyEditsComponent },
  { path: 'my-images', component: MyImagesComponent },
  { path: 'my-moderation-score', component: MyModerationScoreComponent },
  { path: 'my-sentiment-analysis', component: MySentimentAnalysisComponent },
  { path: 'my-translated-sentences', component: MytranslateSentencesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
