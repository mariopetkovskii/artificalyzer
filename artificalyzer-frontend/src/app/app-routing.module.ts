import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatGptComponent } from './chatGpt-aimodel/components/chat-gpt/chat-gpt.component';
import { LoginComponent } from './login/components/login/login.component';
import { RegisterComponent } from './register/components/register/register.component';

const routes: Routes = [
  {  path: 'chat', component: ChatGptComponent },
  {  path: 'login', component: LoginComponent},
  {  path: 'register', component: RegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
