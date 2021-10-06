package samsung;

public class GalaxyNote extends phone {

	int channel;
	
	GalaxyNote(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	void turnOnDmb() {
		System.out.println("chnnel: " + channel + "번 TV 수신 시작~");
	}
	void channelChange(int channel) {
		System.out.println("chnnel: " + channel + "번으로 채널 변경~");
	}
	void turnOffDmb() {
		System.out.println("TV 수신을 종료합니다.");
	}
	void penDrawing() {
		System.out.println("드로잉을 시작해요 펜을 어서 꺼내요!");
	}
	void penDrawingEnd() {
		System.out.println("드로잉을 끝내요 펜을 어서 집어넣어요!");
	}
}
