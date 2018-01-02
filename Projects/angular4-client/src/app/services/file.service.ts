import { Injectable } from '@angular/core';
import { FileDropModule, UploadFile, UploadEvent } from 'ngx-file-drop';


@Injectable()
export class FileService {
    

    public fileOver(event) {
        console.log(event);
    }

    public fileLeave(event) {
        console.log(event);
    }

    public packageFiles(uploads: UploadFile[]): File[] {
        let files: File[] = [];
        for (var file of uploads) {
            file.fileEntry.file(info => {
                files.push(info);
            });
        }
        return files;
    }

}
