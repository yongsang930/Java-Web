package step7;
/**
 * synchronized(동기화) 처리의 목적
 * : 멀티 스레딩시 공유 데이터의 안전성을 위해 사용
 * 하나의 좌석 정보를 가진 극장
 * 이 경우 좌석 정보 상태가 false 이면 예매가 성공되고
 * true 이면 이미 좌석이 예매된 상태이므로 예매 실패 메세지를 
 * 출력해야 한다.
 * but 멀티 스레딩시에는 위의 작업에 문제가 생길 수 있다.
 * 하나의 스레드가 예매 작업 도중 다른 스레드가 동시에 수행되면서
 * 예매 완료 (seat=true)가 되기 전에 다시 예매 성공될 수 있는 가능성이 있다.
 * 이를 막기 위해 synchronized(동기화) 처리하여 그 부분만 단일 스레드 환경으로 
 * 변경하면 문제를 예방할 수 있다.
 */
class Theater implements Runnable{
	private boolean seat=false;
	@Override
	public void run() {
		reserve();
	}
	//synchronized 를 명시하면 단일 스레드 환경으로 실행 된다.
	public synchronized void reserve(){
		String name=Thread.currentThread().getName();
		System.out.println(name+" 스레드 예매 처리 시작..");
		if(seat==false){
			System.out.println(name+" 스레드 예매 성공^O^");
			try {
				Thread.sleep(500);//0.5초간 작업처리소요
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			seat=true;//예매 하였으므로 상태를 true로 변경
		}else{
			System.out.println(name+" 스레드 예매 실패T.T");
		}
	}
}
public class TestSynchronized {
	public static void main(String[] args) {
		//영화정보는 각 스레드에서 공유해야 하므로
		//극장 객체는 하나만 생성하고 Thread 두개에서 공유하여 사용한다.
		Theater th=new Theater();
		Thread t1=new Thread(th,"소지섭");
		Thread t2=new Thread(th,"백박사");
		t1.start();
		t2.start();
	}
}
