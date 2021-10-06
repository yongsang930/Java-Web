package step3;

import java.util.Scanner;

public class Grade {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;
	
	public Grade() {
		super();
	}
	
	public void Input(Scanner sc) {
		System.out.print("이름: ");
		this.name = sc.next();
		System.out.print("국어: ");
		this.kor = sc.nextInt();
		System.out.print("영어: ");
		this.eng = sc.nextInt();
		System.out.print("수학: ");
		this.math = sc.nextInt();
	}
	
	public void tot() {
		total = kor + eng + math; 
	}
	public void avg() {
		avg = total / 3;
	}
	
	public void print() {
		System.out.println("이름" + name);
		System.out.println("국어" + kor);
		System.out.println("영어" + eng);
		System.out.println("수학" + math);
		System.out.println("총점" + total);
		System.out.println("평균" + avg);
	}
}
