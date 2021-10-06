package step1;

public class Person {
	private int a;       // 캡슐화_은닉성을 위해서 사용, 변수는 값을 저장
	private int b;
	
	public Person(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public void print() {
		System.out.println(a);
		System.out.println(b);
	}
}

//DTO         / Set, Get 메서드
//service     / 기능
//test