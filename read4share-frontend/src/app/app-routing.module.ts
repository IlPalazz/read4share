import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdvDetailsComponent } from './components/advs/adv-details/adv-details.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { ChatOverviewComponent } from './components/chat/chat-overview/chat-overview.component';
import { PublishAdvComponent } from './components/advs/publish-adv/publish-adv.component';
import { StatsComponent } from './components/stats/stats.component';

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
  { path: 'publish', component: PublishAdvComponent },
  { path: 'stats', component: StatsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
