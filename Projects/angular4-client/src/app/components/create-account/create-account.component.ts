import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CreateAccountService} from '../../services/create-account-service';

@Component({
    selector: 'app-create-account',
    templateUrl: './create-account.component.html',
    styleUrls: ['./create-account.component.css'],
    providers: [CreateAccountService],
})
export class CreateAccountComponent implements OnInit {

    rForm: FormGroup;
    post: any;
    fname = '';
    mname = ' ';
    lname = '';
    email = '';
    username = '';
    password = '';
    password2 = '';
    titleAlert = 'This field is required.';

    usernameTaken: boolean = null;
    userCreated: boolean = null;
    userCred: string[] = [];

    constructor(private fb: FormBuilder, private dataService: CreateAccountService) {

        this.rForm = fb.group({
            'fname': [null, Validators.required],
            'mname': [null],
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
                if (validate === '1') {
                    this.rForm.get('fname').setValidators([Validators.required, Validators.minLength(3)]);
                    this.titleAlert = 'You need to specify at least 3 characters';
                } else {
                    this.rForm.get('fname').setValidators(Validators.required);
                }
                this.rForm.get('fname').updateValueAndValidity();
            }
        );
    }

    addPost(post) {
        if (post.password === post.password2) {
            this.fname = post.fname;
            if (post.mname !== ' ' || post.name !== '') {
                this.mname = post.mname;
            }
            this.lname = post.lname;
            this.password = post.password;
            this.password2 = post.password2;
            this.email = post.email;
            this.userCred.push(post.fname);

            if (post.mname != null) {
                this.userCred.push(post.mname);
            } else {
                this.userCred.push('');
            }

            this.userCred.push(post.lname);
            this.userCred.push(post.username);
            this.userCred.push(post.password);
            this.userCred.push(post.email);
            console.log(this.userCred);
            this.dataService.userExist(post.username).subscribe(
                (data: any) => {
                    this.usernameTaken = data === true;
                    if (this.usernameTaken) {
                        console.log('impostor (username taken)');
                        this.resetForm();
                    }
                    else {
                        this.dataService.createAccount(this.userCred).subscribe(
                            (createdUser: any) => {
                                this.userCreated = true;
                                console.log('success: user created', createdUser);
                                this.resetForm();
                            },
                            (err) => {
                                console.log('error creating user', err);
                                this.userCreated = false;
                                this.resetForm();
                            }
                        );
                    }
                },
                (err) => {
                    console.log(err);
                    this.resetForm();
                }
            );

        }
    }

    resetForm(): void {
        this.fname = '';
        this.userCred = [];
    }


}
