package Practice7_4;

class MyTv{
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	MyTv(){}
	
	void setChannel(int channel) {
		if(channel < MAX_CHANNEL && channel > MIN_CHANNEL)
		this.channel = channel;
	}
	int  getChannel() {
		return this.channel;
	}
	void setVolume(int volume) {
		if(volume < MAX_VOLUME && volume > MIN_VOLUME)
		this.volume = volume;
	}
	int  getVolume() {
		return this.volume;
	}
	
}

public class Exercise7_4 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		
		t.setChannel(10);
		System.out.println("CH:"+ t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+ t.getVolume());
		
		t.setChannel(100);
		System.out.println("CH:"+ t.getChannel());
		t.setVolume(200);
		System.out.println("VOL:"+ t.getVolume());
	}
}
