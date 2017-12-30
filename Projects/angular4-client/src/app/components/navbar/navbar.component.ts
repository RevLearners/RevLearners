import {Component} from '@angular/core';
import { User } from '../../model/user';
import { LoginCredentialsService } from '../../services/login-credentials.service';


@Component ({
    selector: 'app-nav-bar',
    templateUrl: './navbar.component.html',
    styleUrls:[
        './navbar.component.css'
    ]
})
export class NavbarComponent{
  
  user: User;
  
constructor(private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    }

}