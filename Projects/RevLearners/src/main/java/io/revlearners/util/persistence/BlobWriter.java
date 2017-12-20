package io.revlearners.util.persistence;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import io.revlearners.util.commons.configs.Constants;

public class BlobWriter {

	public static Blob writeToBlob(Session session, String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);

		return Hibernate.getLobCreator(session).createBlob(fis, file.length());
	}

	public static void writeToFile(String fileName, byte[] bytes) throws IOException {
		File file;
		String ext;

		ext = FilenameUtils.getExtension(fileName);
		file = File.createTempFile(Constants.FILE_DIR + fileName, ext);
		file.deleteOnExit();

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytes);
		fos.flush();
		fos.close();
		
		Desktop.getDesktop().open(file);
	}
}
