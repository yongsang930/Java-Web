package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestEchoServer {

	public void go() throws IOException {
		ServerSocket serverSocket = new ServerSocket(5432);// ��ǥ��ȭ��ȣ
		System.out.println("����������");
		Socket socket = serverSocket.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

		try {
			while (true) {
				String mess = br.readLine();
		System.out.println(socket.getInetAddress() + "���Ǹ� :" + mess);
				pw.println(mess);
				System.out.println("" + mess + "Ŭ���̾�Ʈ�� ����");
			}
		} catch (IOException e) {
			System.out.println("�����Ϳ���");
		}
          serverSocket.close();
          br.close();
          pw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TestEchoServer ts = new TestEchoServer(); 
		ts.go();
	}

}
