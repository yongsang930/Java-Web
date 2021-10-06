public class FirstClass2 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.println("first");
			} else if ( i == 1) {
				System.out.println("second");
			} else {
				System.out.println("third");
			}
			Math2.ronaldo();
		}
	}
}

class Math2 {
	
	Math2() {}

	static void ronaldo() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("@");
		}
		System.out.println();
	}
}

