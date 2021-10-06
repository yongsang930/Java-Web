package Practice7_3;

class Product {
	int price;
	int bonusPoint;
	
	public Product() { // 기본생성자를 추가해주어야 함
	}

	public Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv extends Product {
	
	Tv() {
	}

	public String toString() {
		return "TV";
	}
}

public class Exercise7_3 {
	public static void main(String[] args) {
		Tv t = new Tv();

	}
}
