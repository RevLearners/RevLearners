import {Routes} from '@angular/router'

import { CreateAccountComponent} from './components/CreateAccount/CreateAccount.component';
import { HomeComponent } from './components/home/home.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/Login/Login.component';
import { CreateChallengeComponent } from './components/CreateChallenge/CreateChallenge.component';
import { SubmitCertificationComponent } from './components/submit-certification/submit-certification.component';
import { ProfileComponent } from './components/profile/profile.component';

export const appRoutes:Routes = [
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
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: '',
        component: HomeComponent
    }
]