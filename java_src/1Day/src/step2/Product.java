package step2;

import java.util.Scanner;

// 입출력용
public class Product {
	
	private String name;
	private int Co;
	private int price;
	
	public Product() {
		super();
	}
	
// 객체를 매개변수로 사용하면 훨씬 편함	
	
	public void input(Scanner sc) {     
		System.out.println("제품명: ");
		name = sc.next();
		System.out.println("제품번호: ");
		Co = sc.nextInt();
		System.out.println("가격: ");
		price = sc.nextInt();
	}
	
	public void print() {
		System.out.println("제품명: ");
		System.out.println(name);
		System.out.println("제품번호: ");
		System.out.println(Co);
		System.out.println("가격: ");
		System.out.println(price);
	}
}
