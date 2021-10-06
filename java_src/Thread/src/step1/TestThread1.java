package step1;
/**
 * 스레드를 생성하는 방법 중에 extends Thread 로 하고 
 * run() 오버라이딩
 * 우리는 아래 Worker 스레드를 정의하고 
 * 객체 생성 후에 start()를 시켜 호출해
 * 실행가능상태로(Runnable)로 보낸다.
 * 그러면 스레드 스케줄러가 스케줄링을 하면
 * run() 메서드가 수행된다.
 */
class Worker extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("work run()...." + i);
		}

	}
}

class Test {
	public void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Test test()...." + i);

		}
	}
}
	public class TestThread1 {
		public static void main(String[] args) {// main도 스레드
			
			 Test t=new Test(); t.test(); //항상 test() 메서드가 수행 완료되어야 main
			 //thread가 종료된다.
			
			Worker w = new Worker();
			w.start();// 스레드를 실행 가능 상태로 보내 스케줄링 받게한다.
			System.out.println("main thread 종료!");
		}
}
