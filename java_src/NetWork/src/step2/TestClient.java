package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public void go() throws UnknownHostException, IOException {
		Socket socket=new Socket("localhost",5432);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        	
	PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
	System.out.println("������ ������ �����͸� �Է��ϼ���");
	String str =br.readLine(); 
	pw.println(str);
	System.out.println("Client���� �Ϸ� ������ ����"+str); 
	pw.close();
	br.close();
	socket.close();
	
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			new TestClient().go();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}

}
