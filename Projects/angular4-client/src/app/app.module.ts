import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {CreateAccountComponent} from './components/create-account/CreateAccount.component';
import {appRoutes} from './routing';
import {HomeComponent} from './components/home/home.component';
import {CreateAccountService} from './service/create-account-service';
import {HttpClientModule} from '@angular/common/http';
import {LoginComponent} from './components/login/Login.component';
import {CreateChallengeComponent} from './components/create-challenge/CreateChallenge.component';
import {SubmitCertificationComponent} from './components/submit-certification/submit-certification.component';
import {CompleteChallengeComponent} from './components/complete-challenge/complete-challenge.component';
import {ReviewChallengeComponent} from './components/review-quiz/review-challenge.component';
import {NewQuestionComponent} from './components/new-question/new-question.component';
import {ProfileComponent} from './components/profile/profile.component';
import {PageDneComponent} from './components/page-dne/page-dne.component';
import { BackendService } from './services/backend.service';
import { FileService } from './services/file.service';
import { LoginCredentialsService } from './services/login-credentials.service';
import { QuestionService } from './services/question.service';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { ViewChallengesComponent } from './components/view-challenges/view-challenges.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { CreateQuestionComponent } from './components/create-question/create-question.component';
import { ApproveCertificationsComponent } from './components/approve-certifications/approve-certifications.component';
import { MessagesComponent } from './components/messages/messages.component';


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
        NewQuestionComponent,
        ProfileComponent,
        PageDneComponent,
        NotificationsComponent,
        ViewChallengesComponent,
        LeaderboardComponent,
        CreateQuestionComponent,
        ApproveCertificationsComponent,
        MessagesComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule.forRoot(appRoutes),
        HttpClientModule,
        ReactiveFormsModule
    ],
    providers: [CreateAccountService, BackendService, FileService, LoginCredentialsService, QuestionService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
