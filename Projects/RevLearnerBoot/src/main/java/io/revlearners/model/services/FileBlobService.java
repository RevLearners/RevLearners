package io.revlearners.model.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.MimeType;
import io.revlearners.model.services.interfaces.IFileBlobService;
import io.revlearners.model.services.interfaces.IMimeTypeRepository;

@Service
public class FileBlobService extends CrudService<FileBlob> implements IFileBlobService {

	@Autowired
	private IMimeTypeRepository mimeRepo;

	@Override
	public Serializable findOneMime(Long id) {
		return mimeRepo.findOne(id);
	}

	@Override
	public MimeType findOneMimeByName(String contentType) {
		return mimeRepo.findMimeTypeByName(contentType);
	}
}
