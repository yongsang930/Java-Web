package practice3;

public class ClassInfoExample {

	public static void main(String[] args) {
		Car1 car = new Car1(100);
		Class clazz = car.getClass();
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
	}

}
