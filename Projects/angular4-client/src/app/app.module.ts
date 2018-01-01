import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { appRoutes } from './routing';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { CreateChallengeComponent } from './components/create-challenge/create-challenge.component';
import { SubmitCertificationComponent } from './components/submit-certification/submit-certification.component';
import { CompleteChallengeComponent } from './components/complete-challenge/complete-challenge.component';
import { ReviewChallengeComponent } from './components/review-quiz/review-challenge.component';
import { NewQuestionComponent } from './components/new-question/new-question.component';
import { ProfileComponent } from './components/profile/profile.component';
import { PageDneComponent } from './components/page-dne/page-dne.component';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { ViewChallengesComponent } from './components/view-challenges/view-challenges.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { ApproveCertificationsComponent } from './components/approve-certifications/approve-certifications.component';
import { MessagesComponent } from './components/messages/messages.component';

import { CreateAccountService } from './services/create-account-service';
import { BackendService } from './services/backend.service';
import { FileService } from './services/file.service';
import { LoginCredentialsService } from './services/login-credentials.service';
import { QuestionService } from './services/question.service';
import { AuthenticationService } from './services/authentication.service';
import { VerifyAccountComponent } from './components/verify-account/verify-account.component';
import { VerifyEmailComponent } from './components/verify-email/verify-email.component';

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
        ApproveCertificationsComponent,
        MessagesComponent,
        VerifyEmailComponent,
        VerifyAccountComponent,
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
