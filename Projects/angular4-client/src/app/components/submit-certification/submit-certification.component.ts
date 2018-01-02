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
import { FileDropModule, UploadFile, UploadEvent } from 'ngx-file-drop';
import { FileUploadComponent } from '../file-upload/file-upload.component';

@Component({
  selector: 'app-submit-certification',
  templateUrl: './submit-certification.component.html',
  styleUrls: ['./submit-certification.component.css']
})
export class SubmitCertificationComponent {
    
  user: User;
  token: SessionToken = null;

  uploads: UploadFile[];
  userForm: FormGroup;
  file: any;
  fd: FormData;

  @ViewChild(FileUploadComponent)
   set appFileUpload(component: FileUploadComponent){
     this.uploads = component.files;
   }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    if(this.token == null){
      this.rout.navigate(['401']);
    }
  }

  constructor(private fb: FormBuilder, private validate: LoginCredentialsService,
  private rout: Router, private fs: FileService, private spinner: Ng4LoadingSpinnerService) {
    this.userForm = fb.group({
      'file': [null, Validators.required]
    });
  }

  OnSubmit() {
    this.spinner.show();
    this.fs.packageFiles(this.uploads);
    this.spinner.hide();
  }



}

