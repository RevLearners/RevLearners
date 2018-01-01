import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../../model/user';
import { SessionToken } from '../../model/session-token';
import {Router} from '@angular/router';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';
import { BackendService } from '../../services/backend.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { FileService } from '../../services/file.service';

@Component({
  selector: 'app-submit-certification',
  templateUrl: './submit-certification.component.html',
  styleUrls: ['./submit-certification.component.css']
})
export class SubmitCertificationComponent {
    /*
  user: User;
  token: SessionToken = null;

  userForm: FormGroup;
  files: File[];
  @ViewChild('UserImage') User_Image;

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    if(this.token == null){
      this.rout.navigate(['401']);
    }
  }

  constructor(private fb: FormBuilder, private validate: LoginCredentialsService,
  private rout: Router, private fs: FileService, private spinner: Ng4LoadingSpinnerService) {
    this.userForm = this.fb.group({
      'UserImage': ['', Validators.required]
    });
  }

  OnSubmit() {
    this.spinner.show();
    const Image = this.User_Image.nativeElement;
    if (Image.files && Image.files[0]) {
      this.files = Image.files[0];
    }
    const ImageFile: File = this.file;

    const formData: FormData = new FormData();
    formData.append('UserImage', ImageFile, ImageFile.name);

    this.fs.sendFiles();

    this.spinner.hide();

    console.log("File loaded:");
    console.log(ImageFile);
  }

*/

}

