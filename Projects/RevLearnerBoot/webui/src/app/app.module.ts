import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {CreateAccountComponent} from './components/CreateAccount/CreateAccount.component';
import {appRoutes} from './routing';
import {HomeComponent} from './components/home/home.component';
import {CreateAccountService} from './service/create-account-service';
import {HttpClientModule} from '@angular/common/http';
import {LoginComponent} from './components/Login/Login.component';
import {CreateChallengeComponent} from './components/CreateChallenge/CreateChallenge.component';
import {SubmitCertificationComponent} from './components/submit-certification/submit-certification.component';
import {CompleteChallengeComponent} from './components/complete-challenge/complete-challenge.component';
import {ReviewChallengeComponent} from './components/review-quiz/review-challenge.component';
import {GenerateChallengeComponent} from './components/generate-quiz/generate-challenge.component';
import {NewQuestionComponent} from './components/new-question/new-question.component';
import {ProfileComponent} from './components/profile/profile.component';
import {PageDneComponent} from './components/page-dne/page-dne.component';


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
        PageDneComponent
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
export class AppModule {
}
