package step6;

/**
 * implements Runnable �� ������ ���� �д� ����� ������� ���� ����� �����带 ���� ������ �FƼ ������ �ϴ� ����
 */
class ReadWorker implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�������� �����͸� �д� ������.." + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class WriteWorker implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("������ �����͸� ���� ������.." + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TestThread6 {
	public static void main(String[] args) {
		// ReadWorker�� WriteWorker�� �̿��� ������ ������ ������ start()
		ReadWorker worker1 = new ReadWorker();
		Thread t1 = new Thread(worker1);
		Thread t2 = new Thread(new WriteWorker());
		t1.start();
		try {
			t1.join();// t1 ������ ���� �Ϸ�ñ��� �ٸ� ������ ���//main �����嵵 ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		System.out.println("*****main thread ����****");
	}
}
