// MODULES //
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

// COMPONENTS //
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AddUserBtnComponent } from './components/add-user-btn/add-user-btn.component';
import { SwitchBtnComponent } from './components/switch-btn/switch-btn.component';
import { UserComponent } from './components/user/user.component';
import { BookComponent } from './components/book/book.component';
import { BodyComponent } from './components/body/body.component';

@NgModule({
  // Only for components
  declarations: [AppComponent, HeaderComponent, FooterComponent, AddUserBtnComponent, SwitchBtnComponent, UserComponent, BookComponent, BodyComponent],
  // Only for modules
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    FontAwesomeModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
