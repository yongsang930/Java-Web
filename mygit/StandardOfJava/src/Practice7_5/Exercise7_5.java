package Practice7_5;

class MyTv2 {

	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	MyTv2() {
	}

	void setChannel(int channel) {
		if (channel < MAX_CHANNEL && channel > MIN_CHANNEL)

			this.prevChannel = this.channel;
		this.channel = channel;
	}

	void gotoPrevChannel() {
		setChannel(prevChannel);
	}

	int getChannel() {
		return this.channel;
	}

	void setVolume(int volume) {
		if (volume < MAX_VOLUME && volume > MIN_VOLUME)
			this.volume = volume;
	}

	int getVolume() {
		return this.volume;
	}
}

public class Exercise7_5 {
	public static void main(String[] args) {

		MyTv2 t = new MyTv2();

		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setChannel(20);
		System.out.println("CH:" + t.getChannel());

		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());

	}
}
