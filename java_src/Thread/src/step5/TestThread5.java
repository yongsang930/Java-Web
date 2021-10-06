package step5;
/**
 * implements Runnable 방식으로 스레드 생성
 */
class Worker implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			//이전 예제처럼 Thread를 상속 받지 않앗으므로
			//바로 getName() 호출할수 없다.
			//currentThread() 를 응용해서 소지섭 worker run 0
			//String name=Thread.currentThread().getName();
			//static 이므로 Thread 클래스명. 으로 접근한다.
			System.out.println(Thread.currentThread().getName()+"worker run..."+i);
		}
	}
}
public class TestThread5 {
	public static void main(String[] args) {
		//동일한 작업을 수행하는 스레드를 두개 생성
		Worker worker1=new Worker();
		Thread t1=new Thread(worker1,"소지섭");//is a 관계를 has a 관계로 대체
	
		System.out.println("우선순위 : "+t1.getPriority());// 기본 5
		Thread t2=new Thread(worker1,"백박사");
		t2.setPriority(Thread.MAX_PRIORITY);//10으로 세팅
		t1.start(); t2.start();
		System.out.println("main thread 종료");
	}
}
