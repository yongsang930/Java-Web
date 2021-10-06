package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {


public void go() throws IOException{
		
		ServerSocket serverSocket= new ServerSocket(5432);//��ǥ��ȭ��ȣ 
		System.out.println("����������");
		
		try{   
			while(true){ 
				//����ϴٰ� Ŭ���̾�Ʈ �����ϸ� ����ȴ�....�Ϲ� ������ ��ȯ���ش�.
				//Ŭ���̾�Ʈ�� �Ϲݼ����̶� ��ȭ�Ѵ�.
				//socket�� ���� ����
				Socket socket = serverSocket.accept();
				//8bit Stream�� -> 16bit Stream���� ��ȯ�Ѵ�.
				InputStream is=socket.getInputStream();
				InputStreamReader ir=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(ir);
		   
				try{
	System.out.println(socket.getInetAddress()+"���� �� : "+br.readLine());	
				
				}catch(IOException ie) {
					
				}
				br.close();
				socket.close();
				}	
		        
		} finally{
		        	if(serverSocket !=null)
		        		serverSocket.close();
		        }
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestServer ts = new TestServer(); 
		try{
			ts.go();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	
	}

}
