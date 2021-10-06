package Practice7_7;

class Outer{
	static class Inner {
		int iv = 200;
	}
}

public class Exercise7_7 {
	public static void main(String[] args) {
		
		Outer o = new Outer();
		
		Outer.Inner i = new Outer.Inner();
		
		System.out.println(i.iv);
		
	}
}
