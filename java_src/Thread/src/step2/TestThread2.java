package step2;
/**
 * Worker 스레드 실행을 지정한 시간 간격으로
 * 중단시키고 다시 재개시키는 프로그램
 */
class Worker extends Thread{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("worker run().."+i);
			//Thread 실행 주기를 1초 간격으로 실행되게 한다.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class TestThread2 {
	public static void main(String[] args) {
		Worker w= new Worker();
		w.start();
		System.out.println("main thread 종료!");

	}
}
