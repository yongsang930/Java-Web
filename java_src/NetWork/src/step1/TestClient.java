package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public void go() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 5432);
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		InputStream is = System.in; 
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir); 
		System.out.println("전송할 내용을 입력하세요 :"); 
		String mess=br.readLine(); 
		pw.println(mess);
		System.out.println(""+mess+"서버에 전송");
		br.close();
		pw.close();
		socket.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		TestClient ts = new TestClient(); 
	
		try{
			ts.go();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	
	}

}
