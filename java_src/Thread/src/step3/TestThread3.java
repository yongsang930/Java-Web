package step3;
class Worker extends Thread{
	Worker(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(getName()+"worker run.."+i);
		}
	}
}
public class TestThread3 {
	public static void main(String[] args) {
		Worker w=new Worker("xxxxx");
		w.start();
		Worker w2=new Worker("xxxxx");
		w2.start();
		System.out.println("main thread xx!");
	}
}
