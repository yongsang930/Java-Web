package step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestConsoleIO1 {
	public static void main(String[] args) {
		
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(ir);
		
		try {
			while(true) {
				System.out.println("친구 이름을 쓰세요");
				String str = br.readLine();
				if(str.contains("그만")) {
					System.out.println("입력이 완료되었습니다.");
					break;
				}
				System.out.println("읽은 내용 :" + str);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
