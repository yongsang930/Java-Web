package step7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsolService {
	
	public void order(String fileName) throws IOException{
		
		File file = new File(fileName);
		file.getParentFile().mkdir();
		
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);  // 읽을때는 바이트 출력을 문자
		BufferedReader br = new BufferedReader(ir);
		
		
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw,true);
		
		while(true) {
			
			System.out.println("저녁메뉴를 입력하세요: ");
			String str = br.readLine();
			if(str.contains("주문")) {
				System.out.println("주문완료!");
				break;
			}
			pw.println(str);
			System.out.println(str+" 오케이!");
		}
		pw.close();
		br.close();
	}
}
