package step3;

public class Person {
	private String name;
	private int money;
	
	public Person(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", money=" + money + "]";
	}
}
