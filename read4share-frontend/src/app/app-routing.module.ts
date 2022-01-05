import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdvDetailsComponent } from './components/advs/adv-details/adv-details.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { ChatOverviewComponent } from './components/chat/chat-overview/chat-overview.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent,
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home/advs/:advId', component: AdvDetailsComponent },
  { path: 'chat', component: ChatOverviewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
