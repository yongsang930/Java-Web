package Chapter_7;

interface I {
	void methodB();
}

public class InterFaceTest2 {
	public static void main(String args[]) {
		P a = new P();
		a.method(new C());
	}
}

class P {
	void method(I i) {
		i.methodB();
	}
}

class C implements I {
	public void methodB() {
		System.out.println("C클래스의 메서드 실행");
	}
}
class D implements I {
	public void methodB() {
		System.out.println("D클래스의 메서드 실행");
	}
}
class E implements I {
	public void methodB() {
		System.out.println("E클래스의 메서드 실행");
	}
}
class F implements I {
	public void methodB() {
		System.out.println("F클래스의 메서드 실행");
	}
}

