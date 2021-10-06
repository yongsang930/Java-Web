package step2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileWriter fw = new FileWriter("c:\\java-kosta/output4.txt", true); // 파일을 가져온다, true(데이터를 누적한다)
			PrintWriter pw = new PrintWriter(fw,true); // 메모장에 적겠다
			pw.println("아이유");
			
			System.out.println("데이터 기록");
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
