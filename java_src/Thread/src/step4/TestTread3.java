package step4;

class ServerWorker extends Thread {
	private int time;

	ServerWorker(String name, int time) {
		super(name);
		this.time = time;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Worker run()..." + i);
			try {
				Thread.sleep(time); // 1000이면 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " 서버 스레드 서비스..");
		}
	}
}

public class TestTread3 {
	public static void main(String[] args) {
		
		ServerWorker wo1 = new ServerWorker("박용상", 1000);
		wo1.start();
		ServerWorker wo2 = new ServerWorker("김예솔", 3000);
		wo1.start();
		
		System.out.println();
	}
}
