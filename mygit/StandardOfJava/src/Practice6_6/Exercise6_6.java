package Practice6_6;

class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistace(int x, int y) {
		return Math.sqrt(Math.pow((this.x-x),2) + Math.pow((this.y-y),2));
	}
}

public class Exercise6_6 {

	public static void main(String[] args) {
		MyPoint point = new MyPoint(1,1);
		
		System.out.println(point.getDistace(2, 2));
	}
}
