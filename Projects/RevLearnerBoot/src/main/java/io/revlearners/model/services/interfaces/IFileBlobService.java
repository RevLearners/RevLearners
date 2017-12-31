package io.revlearners.model.services.interfaces;

import java.io.Serializable;

import io.revlearners.model.bean.FileBlob;

public interface IFileBlobService extends ICrudService<FileBlob> {

	Serializable findOneMime(Long id);

}
