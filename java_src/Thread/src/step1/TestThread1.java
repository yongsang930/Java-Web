package step1;
/**
 * �����带 �����ϴ� ��� �߿� extends Thread �� �ϰ� 
 * run() �������̵�
 * �츮�� �Ʒ� Worker �����带 �����ϰ� 
 * ��ü ���� �Ŀ� start()�� ���� ȣ����
 * ���డ�ɻ��·�(Runnable)�� ������.
 * �׷��� ������ �����ٷ��� �����ٸ��� �ϸ�
 * run() �޼��尡 ����ȴ�.
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
		public static void main(String[] args) {// main�� ������
			
			 Test t=new Test(); t.test(); //�׻� test() �޼��尡 ���� �Ϸ�Ǿ�� main
			 //thread�� ����ȴ�.
			
			Worker w = new Worker();
			w.start();// �����带 ���� ���� ���·� ���� �����ٸ� �ް��Ѵ�.
			System.out.println("main thread ����!");
		}
}
