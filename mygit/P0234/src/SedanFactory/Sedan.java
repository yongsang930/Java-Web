package SedanFactory;

import Component.Tire;

public class Sedan {
	public static void main(String[] args) {
		Tire comTire = new Tire();
		comTire.setSize(20);
		
		System.out.println(comTire.gerSize());
	}

}
