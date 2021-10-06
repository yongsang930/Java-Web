package step5;
/**
 * implements Runnable ������� ������ ����
 */
class Worker implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			//���� ����ó�� Thread�� ��� ���� �ʾ����Ƿ�
			//�ٷ� getName() ȣ���Ҽ� ����.
			//currentThread() �� �����ؼ� ������ worker run 0
			//String name=Thread.currentThread().getName();
			//static �̹Ƿ� Thread Ŭ������. ���� �����Ѵ�.
			System.out.println(Thread.currentThread().getName()+"worker run..."+i);
		}
	}
}
public class TestThread5 {
	public static void main(String[] args) {
		//������ �۾��� �����ϴ� �����带 �ΰ� ����
		Worker worker1=new Worker();
		Thread t1=new Thread(worker1,"������");//is a ���踦 has a ����� ��ü
	
		System.out.println("�켱���� : "+t1.getPriority());// �⺻ 5
		Thread t2=new Thread(worker1,"��ڻ�");
		t2.setPriority(Thread.MAX_PRIORITY);//10���� ����
		t1.start(); t2.start();
		System.out.println("main thread ����");
	}
}
