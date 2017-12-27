import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-submit-certification',
  templateUrl: './submit-certification.component.html',
  styleUrls: ['./submit-certification.component.css']
})
export class SubmitCertificationComponent {

  UserForm: FormGroup;
  UserImageFile: File;
  @ViewChild('UserImage') User_Image;
  
  constructor(private fb: FormBuilder) { 
    this.UserForm = this.fb.group({
      'UserImage': ['', Validators.required]
    });
  }

    OnSubmit(value) {
    const Image = this.User_Image.nativeElement;
    if (Image.files && Image.files[0]) {
      this.UserImageFile = Image.files[0];
    }
    const ImageFile: File = this.UserImageFile;

    const formData: FormData = new FormData();
    formData.append( 'UserImage', ImageFile, ImageFile.name);
  }
  

}

