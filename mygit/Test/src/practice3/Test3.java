package practice3;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Student[] person = new Student[5];
		int min = 400;
		String name = "empty";

		for (int i = 0; i < person.length; i++) {
			person[i] = new Student("null", 0);
		}

		for (int i = 0; i < person.length; i++) {
			person[i] = new Student(scan.next(),scan.nextInt()) ;
		}

		for (int i = 0; i < person.length; i++) {
			if (min > person[i].height) {
				min = person[i].height;
				name = person[i].name;
			}
		}
		System.out.println(name + " " + min);
		scan.close();
	}
}

class Student {
	String name;
	int height;

	Student(String name, int height) {
		this.name = name;
		this.height = height;
	}
}