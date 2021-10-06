package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java.net 을 이용해 클라이언트 프로그램 만들기 서버에 접속하여 서버가 전송하는 데이터를 입력 받아 
 * 화면에 출력하는 클라이언트프로그램 
 * 1. Socket(ip, port) 생성 
 * 2. socket.getInputStream() : InputStream 을 반환 
 * 3.8bit -> 16bit 로 변환 : InputStreamReader 
 * 4. BufferedReader 
 * 5. readLine()
 *6.close()
 */
public class TestClient {
	public void go() throws UnknownHostException, IOException {// 127.0.0.1 : 항상
																// 자기 컴퓨터 아이피
		Socket socket = new Socket("127.0.0.1", 5432);
		InputStream is=socket.getInputStream();
		//8bit -> 16bit Stream으로 변환
		InputStreamReader ir= new InputStreamReader(is);
		BufferedReader br=new BufferedReader(ir);
		System.out.println("client에서 읽은 내용 : "+br.readLine());
		br.close();
		socket.close();
	}

	public static void main(String[] args) {
		TestClient tc = new TestClient();
		try {
			tc.go();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
