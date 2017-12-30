import { Component , ViewEncapsulation} from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";



@Component({
    selector: 'app-login',
    templateUrl: './Login.component.html',
    styleUrls: ['./Login.component.css'],
    encapsulation: ViewEncapsulation.None,
})
export class LoginComponent {
    rForm: FormGroup;
    username: string = '';
    password: string = '';

    chosenUsername: string = '';
    chosenPassword: string = '';

    userFound: boolean = false;

    database = [
        {
            username: 'Loweski',
            password: 'PewPew'
        },
        {
            username: 'Chantu',
            password: 'notme'
        }
    ];

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
        console.log("storedUsername: " + this.username + " storedPassword: " + this.password);
        console.log("post's username: " + post.username + " post's password: " + post.password);
        for(let i = 0; i<this.database.length; i++){
            console.log("database's username: " + this.database[i].username + " database's password: " + this.database[i].password);
            console.log(this.database[i].username == this.username);
            console.log(this.database[i].password == this.password);
            if((this.database[i].username == this.username) && (this.database[i].password == this.password)){
                this.chosenUsername = this.database[i].username;
                this.chosenPassword = this.database[i].password;
                this.userFound = true;
                console.log("test1");
                break;
            }
            else{
                this.userFound = false;
            }
            console.log("test2");
        }

    }

    resetForm(){
        this.username = '';
        this.password = '';
    }
}