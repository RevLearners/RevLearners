package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.services.interfaces.IFileBlobService;

@Service
public class FileBlobService extends CrudService<FileBlob> implements IFileBlobService {

}
