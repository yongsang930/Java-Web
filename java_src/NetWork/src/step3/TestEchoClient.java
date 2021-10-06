package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestEchoClient {

	public void go() throws UnknownHostException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Socket socket = new Socket("localhost", 5432);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		try {
			while (true) {
				System.out.println("전송할 내용 입력 :"); 
				String mess = br.readLine();
				pw.println(mess);
				System.out.println("" + mess + "클라이언트에 전송");
System.out.println(socket.getInetAddress() + "님의말 :" + br1.readLine());
			}
		} catch (IOException e) {
			System.out.println("데이터오류");
		}

	     br.close();
	     br1.close();
	     pw.close();
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
