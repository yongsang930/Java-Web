package Practice7_6;

class Outer{
	class Inner{
		int iv = 100;
	}
	
}

public class Exercise7_6 {
	public static void main(String[] args) {
		
		Outer outer = new Outer();
		
		Outer.Inner i = outer.new Inner();
		System.out.println(i.iv);
	}
}
