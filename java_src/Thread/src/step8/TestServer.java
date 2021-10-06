package step8;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java.net을 이용해 서버 프로그램 구성하기 서버가 대기하다가 클라이언트 접속하면 메세지 전송하고 종료하는 일 1.
 * ServerSocket 생성 2. accept() 실행 : 대기하다가 클라이언트 접속하면 일반 소켓을 반환 3. Socket 1)
 * socket.getOutputStream() : OutputStream 2) PrintWriter의 println() 으로 데이터 전송
 * 4. close()
 */
public class TestServer {
	public void go() throws IOException {
		ServerSocket serverSocket = new ServerSocket(5432);
		// 5432 port 지정
		System.out.println("**서버수행중**");
		// 대기하다 클라이언트 접속하면 수행된다. 일반 소켓을 반환
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("***접속아이피***"+socket.getInetAddress());
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);// true: autoflush
			pw.println("이제 마칠 시간 좀만 더 힘내자!~~~");
			pw.close();
			socket.close();
		}
		//serverSocket.close();
	}

	public static void main(String[] args) {
		TestServer ts = new TestServer();
		try {
			ts.go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
