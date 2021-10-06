package Practice6_1;

public class Student {
	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	
	public int getTotal() {
		return kor + eng + math;
	}
	
	public float getAverage() {
		return (float)(Math.round((getTotal() /3.0)*10))/10;
	}
}
