package step9;

abstract class Parent {
	public void eat() {
		System.out.println("먹다");
	}
	
	public abstract void study(); 
}

class Child extends Parent{
	public void study () {
		System.out.println("공부하다");
	}
	
	
}

public class TestAbstract {

	public static void main(String[] args) {
		
		
		Child c = new Child();
		c.eat();
		c.study();
		
		Parent p1 = new Child();
		p1.eat();
		p1.study();
	}
}
