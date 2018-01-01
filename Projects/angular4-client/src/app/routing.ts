import { Routes } from '@angular/router';

import { CreateAccountComponent } from './components/create-account/create-account.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PageDneComponent } from './components/page-dne/page-dne.component';
import { NewQuestionComponent } from './components/new-question/new-question.component';
import { ReviewChallengeComponent } from './components/review-quiz/review-challenge.component';
import { CompleteChallengeComponent } from './components/complete-challenge/complete-challenge.component';
import { CreateChallengeComponent } from './components/create-challenge/create-challenge.component';
import { SubmitCertificationComponent } from './components/submit-certification/submit-certification.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ViewChallengesComponent } from './components/view-challenges/view-challenges.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { ApproveCertificationsComponent } from './components/approve-certifications/approve-certifications.component';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { MessagesComponent } from './components/messages/messages.component';
import { VerifyAccountComponent } from './components/verify-account/verify-account.component';
import { UnauthorizedComponent } from './components/unauthorized/unauthorized.component';

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
        path: 'view-challenges',
        component: ViewChallengesComponent
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
        path: 'new-question',
        component: NewQuestionComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'verify',
        component: VerifyAccountComponent
    },
    {
        path: 'leaderboard',
        component: LeaderboardComponent
    },
    {
        path: 'approve-certifications',
        component: ApproveCertificationsComponent
    },
    {
        path: 'notifications',
        component: NotificationsComponent
    },
    {
        path: 'messages',
        component: MessagesComponent
    },
    {
        path: '401',
        component: UnauthorizedComponent
    },
    {
        path: '403',
        component: UnauthorizedComponent
    },
    {
        path: '**',
        component: PageDneComponent
    }
];
