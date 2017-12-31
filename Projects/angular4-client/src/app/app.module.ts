import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {CreateAccountComponent} from './components/create-account/CreateAccount.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/Login.component';
import {CreateChallengeComponent} from './components/create-challenge/CreateChallenge.component';
import {SubmitCertificationComponent} from './components/submit-certification/submit-certification.component';
import {CompleteChallengeComponent} from './components/complete-challenge/complete-challenge.component';
import {ReviewChallengeComponent} from './components/review-quiz/review-challenge.component';
import {GenerateChallengeComponent} from './components/generate-quiz/generate-challenge.component';
import {NewQuestionComponent} from './components/new-question/new-question.component';
import {ProfileComponent} from './components/profile/profile.component';
import {PageDneComponent} from './components/page-dne/page-dne.component';
import { NotificationsComponent } from './components/notifications/notifications.component';

import {appRoutes} from './routing';

import {CreateAccountService} from './service/create-account-service';
import { BackendService } from './services/backend.service';
import { FileService } from './services/file.service';
import { LoginCredentialsService } from './services/login-credentials.service';
import { QuestionService } from './services/question.service';
import { AuthenticationService }  from './services/authentication.service';

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        CreateAccountComponent,
        HomeComponent,
        LoginComponent,
        CreateChallengeComponent,
        SubmitCertificationComponent,
        CompleteChallengeComponent,
        ReviewChallengeComponent,
        GenerateChallengeComponent,
        NewQuestionComponent,
        ProfileComponent,
        PageDneComponent,
        NotificationsComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule.forRoot(appRoutes),
        HttpClientModule,
        ReactiveFormsModule
    ],
    providers: [CreateAccountService, BackendService, FileService, LoginCredentialsService, 
      QuestionService, AuthenticationService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
