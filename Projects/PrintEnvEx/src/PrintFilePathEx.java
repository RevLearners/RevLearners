import java.io.File;

public class PrintFilePathEx {

	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		File folder = new File(currentDir + "/img");
		
		for(File f : folder.listFiles()) {
			System.out.println(f.getName());
		}
	}
}
