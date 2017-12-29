import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ViewChild } from '@angular/core/src/metadata/di';
import { ViewEncapsulation } from '@angular/core';
import { CreateAccountService } from '../../service/create-account-service';

@Component({
  selector: 'createAccount',
  templateUrl: '../../../../../src/main/resources/public/CreateAccount.component.html',
  styleUrls: ['../../../../../src/main/resources/public/CreateAccount.component.css'],
  providers: [CreateAccountService],
  // encapsulation: ViewEncapsulation.None,
})
export class CreateAccountComponent {

  rForm: FormGroup;
  post: any;
  fname: string = '';
  mname: string = ' ';
  lname: string = '';
  email: string = '';
  username: string = '';
  password: string = '';
  password2: string = '';
  titleAlert: string = 'This field is required.';

  userCred: string[] = [];

  constructor(private fb: FormBuilder, private dataService: CreateAccountService) {

    this.rForm = fb.group({
      'fname': [null, Validators.required],
      'mname': [null, Validators.required],
      'lname': [null, Validators.required],
      'email': [null, Validators.required],
      'username': [null, Validators.required],
      'password': [null, Validators.required],
      'password2': [null, Validators.required],
      'validate': ''
    });
  }

  ngOnInit() {
    this.rForm.get('validate').valueChanges.subscribe(
      (validate) => {
        if (validate == '1') {
          this.rForm.get('fname').setValidators([Validators.required, Validators.minLength(3)]);
          this.titleAlert = "You need to specify at least 3 characters";
        } else {
          this.rForm.get('fname').setValidators(Validators.required);
        }
        this.rForm.get('fname').updateValueAndValidity();
      }
    )
  }

  addPost(post) {
    if (post.password == post.password2) {
      this.fname = post.fname;
      if (post.mname != ' ') {
        this.mname = post.mname;
      }
      this.lname = post.lname;
      this.password = post.password;
      this.password2 = post.password2;
      this.email = post.email;
      this.userCred.push(post.fname);
      this.userCred.push(post.mname);
      this.userCred.push(post.lname);
      this.userCred.push(post.username);
      this.userCred.push(post.password);
      this.userCred.push(post.email);
      console.log(this.userCred);
      this.dataService.createAccount(this.userCred).subscribe(
        (data: any) => console.log(data),
        console.log
      )
        ;
    } else {

    }

  }

  resetForm(){
    this.fname = '';
  }
}
