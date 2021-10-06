package step4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtil {
	
	
	
	
	public void writeDate(String fileName,String content) throws IOException{
		File file = new File(fileName);
		File dir = new File(file.getParent());
		dir.mkdir();
		
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw, true);
		
		pw.println(content);
		pw.close();
	}
	
	public void readFile(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		
		while(str != null) {
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
	}
	
	public void copyFile(String fileName, String destName) throws IOException{
		File file = new File(destName);
		file.getParentFile().mkdirs();
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		PrintWriter pw = new PrintWriter(new FileWriter(file, true),true);
		
		String str = br.readLine();
		while(str != null) {
			pw.println(str);
			str=br.readLine();
		}
		
		pw.close();
		br.close();
	}
}
