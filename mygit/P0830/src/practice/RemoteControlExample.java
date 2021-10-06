package practice;

public class RemoteControlExample {
	public static void main(String[] args) {
		
		RemoteControl rc2 = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("RemontControl - turnOn()");
			}
			
			@Override
			public void turnOff() {
				System.out.println("RemoteControl - turnOff()");
			}
			
			@Override
			public void setVolume(int volume) {
				System.out.println("volume : " + volume);
			}
		};
//		RemoteControl rc;
//		
//		rc = new Television();
//		rc.turnOn();
//		rc.setVolume(11);
//		rc.setVolume(7);
//		rc.turnOff();
//		
//		rc = new Audio();
//		rc.turnOn();
//		rc.setVolume(-2);
//		rc.setVolume(2);
//		rc.turnOff();
//		
//		RemoteControl.changeBattery();
	}
}
