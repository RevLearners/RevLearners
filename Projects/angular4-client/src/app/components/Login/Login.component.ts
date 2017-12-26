import { Component , ViewEncapsulation} from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";



@Component({
    selector: 'Login',
    templateUrl: './Login.component.html',
    styleUrls: ['./Login.component.css'],
    encapsulation: ViewEncapsulation.None,
})
export class LoginComponent {
    rForm: FormGroup;
    username: string = '';
    password: string = '';

    constructor(private fb: FormBuilder) {

        this.rForm = fb.group({
            'username': [null, Validators.required],
            'password': [null, Validators.required],
            'validate': ''
        });
    }

    addPost(post) {
        this.username = post.username;
        this.password = post.password;

    }

    resetForm(){
        this.username = '';
        this.password = '';
    }
}