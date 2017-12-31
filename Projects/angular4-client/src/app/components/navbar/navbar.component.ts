import {Component} from '@angular/core';
import { User } from '../../model/user';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import {Observable} from 'rxjs/Rx';

@Component ({
    selector: 'app-nav-bar',
    templateUrl: './navbar.component.html',
    styleUrls:[
        './navbar.component.css'
    ]
})
export class NavbarComponent{
  
  user: User;
  
  notificationCount = 0;
  messageCount = 0;
  
constructor(private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
      
    }
    
  


//  Observable.interval(200 * 60).subscribe(
//    x => {
//    doSomething();
//    }
//  );
  

}