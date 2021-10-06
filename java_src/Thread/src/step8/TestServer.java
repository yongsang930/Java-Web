package step8;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java.net�� �̿��� ���� ���α׷� �����ϱ� ������ ����ϴٰ� Ŭ���̾�Ʈ �����ϸ� �޼��� �����ϰ� �����ϴ� �� 1.
 * ServerSocket ���� 2. accept() ���� : ����ϴٰ� Ŭ���̾�Ʈ �����ϸ� �Ϲ� ������ ��ȯ 3. Socket 1)
 * socket.getOutputStream() : OutputStream 2) PrintWriter�� println() ���� ������ ����
 * 4. close()
 */
public class TestServer {
	public void go() throws IOException {
		ServerSocket serverSocket = new ServerSocket(5432);
		// 5432 port ����
		System.out.println("**����������**");
		// ����ϴ� Ŭ���̾�Ʈ �����ϸ� ����ȴ�. �Ϲ� ������ ��ȯ
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("***���Ӿ�����***"+socket.getInetAddress());
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);// true: autoflush
			pw.println("���� ��ĥ �ð� ���� �� ������!~~~");
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
