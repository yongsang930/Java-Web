package Practice6_4;

public class Exercise6_4 {
	static double getDistace(int x, int y, int x1, int y1) {

		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)); // ※삼각함수
	}

	public static void main(String[] args) {
		System.out.println(getDistace(1, 2, 8, 9));
	}
}
