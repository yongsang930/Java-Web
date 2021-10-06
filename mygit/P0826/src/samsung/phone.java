package samsung;

public class phone {
	String model;
	String color;
	
	void powerOn() {
		System.out.println("전원을 켰어요");
	}
	void powerOff() {
		System.out.println("전원을 껐어요");
	}
	void callOn() {
		System.out.println("전화가 왔어요!");
	}
	void callOff() {
		System.out.println("전화를 끌게요ㅠ");
	}
	void sendMessage(String message) {
		System.out.println("메세지 보냈다~!");
		System.out.println("보낸 메세지 내용 : " + message);
	}
	void receiveMessage(String message) {
		System.out.println("메세지 왔다~!");
		System.out.println("받은 메세지 내용 : " + message);
	}
	void radioCome() {
		System.out.println("라디오를 수신합니다");
	}
	void radioTrue() {
		System.out.println("라디오 수신을 종료합니다.");
	}

}
