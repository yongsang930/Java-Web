package step7;

import java.io.IOException;

public class TestConsoleService {

	public static void main(String[] args) {
		
		
		
		ConsolService service = new ConsolService();
		
		try {
			service.order("c:\\java-kosta\\iotest\\step3\\order.txt");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
