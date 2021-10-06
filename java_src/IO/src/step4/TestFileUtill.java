package step4;

import java.io.IOException;

public class TestFileUtill {

	public static void main(String[] args) {

		FileUtil fu = new FileUtil();

		String fileName = "c:\\java-kosta\\iotest\\step1\\data.txt";

		try {
			fu.writeDate(fileName, "강남스타일");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fu.readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String destName = "c:\\java-kosta\\iotest\\step1\\data.txt";
		
		try {
			fu.copyFile(fileName,destName);
			System.out.println("copy complete");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
