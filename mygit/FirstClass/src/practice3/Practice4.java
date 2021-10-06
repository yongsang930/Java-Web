package practice3;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Boom[] p = new Boom[6];
		
		for (int i = 0; i < p.length; i++) {
			p[i] = new Boom("¿Ë", 0, 0);
		}

		for (int i = 0; i < p.length - 1; i++) {
			p[i].name = scan.next();
			p[i].height = scan.nextInt();
			p[i].weight = scan.nextDouble();
		}
		scan.close();
		
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i].name.charAt(0) > p[j].name.charAt(0)) {
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

	class Boom {
		String name;
		int height;
		double weight;

		Boom(String name, int height, double weight) {
			this.name = name;
			this.height = height;
			this.weight = weight;
		}
		

	void show() {
		System.out.println(this.name + " " + this.height + " " + this.weight);
		}
	}
