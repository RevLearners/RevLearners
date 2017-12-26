import {Routes} from '@angular/router'

import { CreateAccountComponent} from './components/CreateAccount/CreateAccount.component';
import { HomeComponent } from './components/home/home.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/Login/Login.component';
import { CreateChallengeComponent } from './components/CreateChallenge/CreateChallenge.component';


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
        path: 'home',
        component: HomeComponent
    },
    {
        path: '',
        component: HomeComponent
    }
]