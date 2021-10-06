package step5;

public class Calc {
	private int x;
	private int y;
	
	public Calc(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int add() {
		return x + y;
	}
	public int sub() {
		return x - y;
	}
	public int mul() {
		return x * y;
	}
	public double div() {
		return (double) x / y;
	}
}
