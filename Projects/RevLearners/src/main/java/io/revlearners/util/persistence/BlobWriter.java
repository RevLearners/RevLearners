package io.revlearners.util.persistence;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;

public class BlobWriter {

	public static byte[] writeToBlob(Session session, String filePath) throws IOException {
		File file = new File(filePath);
		return FileUtils.readFileToByteArray(file);
	}

	public static void writeToFile(String fileName, long fileSize, byte[] bytes) throws IOException, SQLException {
		File file;
		String base, ext;
		
		ext = FilenameUtils.getExtension(fileName);
		base = FilenameUtils.getBaseName(fileName);

		file = File.createTempFile(base, ext);
		file.deleteOnExit();
			
		FileUtils.writeByteArrayToFile(file, bytes);

		Desktop.getDesktop().open(file);
	}
}
