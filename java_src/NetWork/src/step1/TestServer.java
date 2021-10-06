package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {


public void go() throws IOException{
		
		ServerSocket serverSocket= new ServerSocket(5432);//대표전화번호 
		System.out.println("서버수행중");
		
		try{   
			while(true){ 
				//대기하다가 클라이언트 접속하면 실행된다....일반 소켓을 반환해준다.
				//클라이언트는 일반소켓이랑 대화한다.
				//socket은 개별 상담원
				Socket socket = serverSocket.accept();
				//8bit Stream을 -> 16bit Stream으로 변환한다.
				InputStream is=socket.getInputStream();
				InputStreamReader ir=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(ir);
		   
				try{
	System.out.println(socket.getInetAddress()+"님의 말 : "+br.readLine());	
				
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
