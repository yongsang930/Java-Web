package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java.net �� �̿��� Ŭ���̾�Ʈ ���α׷� ����� ������ �����Ͽ� ������ �����ϴ� �����͸� �Է� �޾� 
 * ȭ�鿡 ����ϴ� Ŭ���̾�Ʈ���α׷� 
 * 1. Socket(ip, port) ���� 
 * 2. socket.getInputStream() : InputStream �� ��ȯ 
 * 3.8bit -> 16bit �� ��ȯ : InputStreamReader 
 * 4. BufferedReader 
 * 5. readLine()
 *6.close()
 */
public class TestClient {
	public void go() throws UnknownHostException, IOException {// 127.0.0.1 : �׻�
																// �ڱ� ��ǻ�� ������
		Socket socket = new Socket("127.0.0.1", 5432);
		InputStream is=socket.getInputStream();
		//8bit -> 16bit Stream���� ��ȯ
		InputStreamReader ir= new InputStreamReader(is);
		BufferedReader br=new BufferedReader(ir);
		System.out.println("client���� ���� ���� : "+br.readLine());
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
