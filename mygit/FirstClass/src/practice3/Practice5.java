package practice3;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Boom1[] p = new Boom1[6];
		
		for (int i = 0; i < p.length; i++) {
			p[i] = new Boom1("¿Ë", 0, 0);
		}

		for (int i = 0; i < p.length - 1; i++) {
			p[i].name = scan.next();
			p[i].height = scan.nextInt();
			p[i].weight = scan.nextDouble();
		}
		scan.close();
		
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if ((int)p[i].name.charAt(0) > (int)p[j].name.charAt(0)) {
					p[5] = p[j];
					p[j] = p[i];
					p[i] = p[5];
				}
			}
		}
		
		System.out.println("name");
		for (int i = 0; i < p.length-1; i++) {
			p[i].show();
		}
		
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i].weight < p[j].weight) {
					p[5] = p[j];
					p[j] = p[i];
					p[i] = p[5];
				}
			}
		}
		
		System.out.println("\nweight");
		for (int i = 0; i < p.length-1; i++) {
			p[i].show();
		}
	}
}

	class Boom1 {
		String name;
		int height;
		double weight;

		Boom1(String name, int height, double weight) {
			this.name = name;
			this.height = height;
			this.weight = weight;
		}
		

	void show() {
		System.out.println(this.name + " " + this.height + " " + this.weight);
		}
	}
