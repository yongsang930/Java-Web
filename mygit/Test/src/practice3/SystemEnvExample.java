package practice3;

public class SystemEnvExample {

	public static void main(String[] args) {
		String javaHome = System.getenv("path");
		System.out.println("path: " + javaHome);
	}

}
