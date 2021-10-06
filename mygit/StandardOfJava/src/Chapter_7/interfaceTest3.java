package Chapter_7;

class W {
	public void method(R q) {
		q.method();
	}
}
class Q {
	public void method() {
		System.out.println("Q클래스 메서드 실행");
	}
}
class R {
	public void method() {
		System.out.println("R클래스 메서드 실행");
	}
}

public class interfaceTest3 {

	public static void main(String[] args) {
		W w = new W();
		w.method(new R());
	}

}
