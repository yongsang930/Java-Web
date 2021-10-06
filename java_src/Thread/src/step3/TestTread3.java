package step3;

// 부모 클래스인 Thread 생성자에 스레드 이름을 받도록 정의되어 있으므로

// super를 통해 이름을 세팅한다.
// thread의 getName을 통해 이름을 받울 수 있다.

class Worker extends Thread {

	Worker(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Worker run()..." + i);
		}
	}
}

public class TestTread3 {

	public static void main(String[] args) {

		Worker w = new Worker("소지섭");
		w.start();
		Worker w2 = new Worker("박용상");
		w.start();
		Worker w3 = new Worker("김전설");
		w.start();

	}
}
