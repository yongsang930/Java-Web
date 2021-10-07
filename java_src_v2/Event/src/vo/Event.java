package vo;

public class Event {
	private int num;
	private String emali;
	
	public Event(int num, String emali) {
		super();
		this.num = num;
		this.emali = emali;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getEmali() {
		return emali;
	}

	public void setEmali(String emali) {
		this.emali = emali;
	}

	@Override
	public String toString() {
		return "Event [num=" + num + ", emali=" + emali + "]";
	}
}
