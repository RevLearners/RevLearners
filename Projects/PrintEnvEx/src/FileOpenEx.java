import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOpenEx {

	public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir") + "/img/imgUpload.jpg";
		File file = new File(filePath);
		File temp = File.createTempFile("imgupload", "pdf");
		FileOutputStream fos = new FileOutputStream(temp);
		fos.write(new byte[] {'S','o','m','e','t','h','i','n','g'});
		fos.close();
		Desktop.getDesktop().open(temp);
		
	}
}
