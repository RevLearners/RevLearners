import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { RouterModule} from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NavbarComponent} from './components/navbar/navbar.component';
import { CreateAccountComponent} from './components/CreateAccount/CreateAccount.component';
import { appRoutes} from './routing';
import { HomeComponent } from './components/home/home.component';
import { CreateAccountService } from './service/create-account-service';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/Login/Login.component';
import { CreateChallengeComponent } from './components/CreateChallenge/CreateChallenge.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CreateAccountComponent,
    HomeComponent,
    LoginComponent,
    CreateChallengeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CreateAccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
