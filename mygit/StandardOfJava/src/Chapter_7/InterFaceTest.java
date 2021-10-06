package Chapter_7;

class InterFaceTest {
	public static void main(String args[]) {
		A a = new A();
		a.methodA(new D());
	}
}

class A {
	A() {
	};

	void methodA(D b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}
