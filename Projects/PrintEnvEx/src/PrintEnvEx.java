
public class PrintEnvEx {

	public static void main(String[] args) {
		for(String s : System.getenv().keySet()) {
			System.out.println(s + "=>" + System.getenv(s));
		}
	}
	
}
