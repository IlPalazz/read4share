/**
 * MODULES
 */
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { SwiperModule } from 'swiper/angular';

/**
 * MATERIAL COMPONENTS
 */
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatTabsModule } from '@angular/material/tabs';
import { MatRadioModule } from '@angular/material/radio';
import { MatMenuModule } from '@angular/material/menu';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';

/**
 * CUSTOM COMPONENTS
 */
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { CarouselComponent } from './components/advs/carousel/carousel.component';
import { AdvOverviewComponent } from './components/advs/adv-overview/adv-overview.component';
import { AdvDetailsComponent } from './components/advs/adv-details/adv-details.component';
import { ChatOverviewComponent } from './components/chat/chat-overview/chat-overview.component';
import { MessageComponent } from './components/chat/message/message.component';
import { PublishAdvComponent } from './components/advs/publish-adv/publish-adv.component';
import { BookCarouselComponent } from './components/advs/book-carousel/book-carousel.component';
import { BookOverviewComponent } from './components/advs/book-overview/book-overview.component';
import { StatsComponent } from './components/stats/stats.component';

@NgModule({
  // Only for components
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    CarouselComponent,
    AdvOverviewComponent,
    AdvDetailsComponent,
    ChatOverviewComponent,
    MessageComponent,
    PublishAdvComponent,
    BookCarouselComponent,
    BookOverviewComponent,
    StatsComponent,
  ],
  // Only for modules
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    HttpClientModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    MatAutocompleteModule,
    MatTabsModule,
    MatRadioModule,
    SwiperModule,
    MatMenuModule,
    MatCheckboxModule,
    MatSelectModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent],
})
export class AppModule {}
