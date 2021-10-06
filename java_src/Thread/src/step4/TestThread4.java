package step4;
class ServerWorker extends Thread{
	private int time;
	ServerWorker(String name, int time){
		super(name);
		this.time=time;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName()+" ���� ������ ����.."+i);
		}
	}
	
}
public class TestThread4 {
	public static void main(String[] args) {
		//������ ������ 1�ʰ��� , ũ����Ż ������ 3�ʰ���
		ServerWorker worker1=new ServerWorker("������",1000);
		worker1.start();
		ServerWorker worker2=new ServerWorker("ũ����Ż",3000);
		worker2.start();
		System.out.println("****main����****");
		/*
		 * ������ ���� ������ ���� 0~~~9
		 * ũ����Ż ���� ������ ���� 0~~~9
		 */
	}
}
