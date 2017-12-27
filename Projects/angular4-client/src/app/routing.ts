import {Routes} from '@angular/router';

import {CreateAccountComponent} from './components/CreateAccount/CreateAccount.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/Login/Login.component';
import {PageDneComponent} from './components/page-dne/page-dne.component';
import {NewQuestionComponent} from './components/new-question/new-question.component';
import {GenerateChallengeComponent} from './components/generate-quiz/generate-challenge.component';
import {ReviewChallengeComponent} from './components/review-quiz/review-challenge.component';
import {CompleteChallengeComponent} from './components/complete-challenge/complete-challenge.component';
import {CreateChallengeComponent} from './components/CreateChallenge/CreateChallenge.component';
import {SubmitCertificationComponent} from './components/submit-certification/submit-certification.component';
import {ProfileComponent} from './components/profile/profile.component';


export const appRoutes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'CreateAccount',
        component: CreateAccountComponent
    },
    {
        path: 'CreateChallenge',
        component: CreateChallengeComponent
    },
    {
        path: 'Login',
        component: LoginComponent
    },
    {
        path: 'submit-certification',
        component: SubmitCertificationComponent
    },
    {
        path: 'completeChallenge/:id',
        component: CompleteChallengeComponent
    },
    {
        path: 'reviewChallenge/:id',
        component: ReviewChallengeComponent
    },
    {
        path: 'generateChallenge',
        component: GenerateChallengeComponent
    },
    {
        path: 'newQuestion',
        component: NewQuestionComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: '**',
        component: PageDneComponent
    },
];
