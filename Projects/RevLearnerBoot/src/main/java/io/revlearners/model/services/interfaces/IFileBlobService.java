package io.revlearners.model.services.interfaces;

import java.io.Serializable;

import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.MimeType;

public interface IFileBlobService extends ICrudService<FileBlob> {

	Serializable findOneMime(Long id);

	MimeType findOneMimeByName(String contentType);

}
