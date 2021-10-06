package step5;

class Worker implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "worker run..." + i);
		}
	}
}

public class TestTread5 {
	public static void main(String[] args) {
		
		Worker worker = new Worker();
		Thread t1 = new Thread(worker, "박용상");
		System.out.println("우선순위 :" + t1.getPriority());
		Thread t2 = new Thread(worker, "박녕상");
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		System.out.println("main 종료");
	}
}
