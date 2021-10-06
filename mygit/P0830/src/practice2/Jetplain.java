package practice2;

public class Jetplain extends Plain implements Flyable, Soundable {
	public void sound() {
		System.out.println("제트기 소리 : 슈우웅~");
	}
	
	public void fly() {
		System.out.println("제트기가 날아갑니다");
	}
}
