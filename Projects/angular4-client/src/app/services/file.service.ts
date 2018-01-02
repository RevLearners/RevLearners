import { Injectable } from '@angular/core';
import { FileDropModule, UploadFile, UploadEvent } from 'ngx-file-drop';


@Injectable()
export class FileService {

    public packageFiles(uploads: UploadFile[]): FormData {
        let fd: FormData = new FormData();
        for (var file of uploads) {
            file.fileEntry.file(info => {
                fd.append('file', info);
            });
        }
        return fd;
    }
}
