package step2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestInput {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("c:\\java-kosta/output4.txt");
			
			BufferedReader br = new BufferedReader(fr);
			
			String str = br.readLine();
			
			while (str != null) {
				System.out.println(str);
				str=br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
