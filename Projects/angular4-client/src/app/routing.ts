import {Routes} from '@angular/router';

import {CreateAccountComponent} from './components/create-account/CreateAccount.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/Login.component';
import {PageDneComponent} from './components/page-dne/page-dne.component';
import {NewQuestionComponent} from './components/new-question/new-question.component';
import {GenerateChallengeComponent} from './components/generate-quiz/generate-challenge.component';
import {ReviewChallengeComponent} from './components/review-quiz/review-challenge.component';
import {CompleteChallengeComponent} from './components/complete-challenge/complete-challenge.component';
import {CreateChallengeComponent} from './components/create-challenge/CreateChallenge.component';
import {SubmitCertificationComponent} from './components/submit-certification/submit-certification.component';
import {ProfileComponent} from './components/profile/profile.component';


export const appRoutes: Routes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'create-account',
        component: CreateAccountComponent
    },
    {
        path: 'create-challenge',
        component: CreateChallengeComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'submit-certification',
        component: SubmitCertificationComponent
    },
    {
        path: 'complete-challenge/:id',
        component: CompleteChallengeComponent
    },
    {
        path: 'review-challenge/:id',
        component: ReviewChallengeComponent
    },
    {
        path: 'generate-challenge',
        component: GenerateChallengeComponent
    },
    {
        path: 'new-question',
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
