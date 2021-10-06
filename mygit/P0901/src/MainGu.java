import java.util.Scanner;

public class MainGu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Time team = new Time();
		
		team.setHour(3);
		
		
	}
}

 class Time {
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int h) {
		if (h < 0 || h > 23) return;
		hour = h;
		
		System.out.println(hour);
	}
}