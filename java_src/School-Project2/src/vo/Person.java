package vo;

public abstract class Person {
	//Person 객체를 생성 해야할 이유가 없어서 선언
	//반드시 abstract method 선언을 해야 하는 것은 아니다.
	private String tel;
	private String name;
	private String address;
	
	//Constructor, set/get, toString()\
	public Person(String tel, String name, String address) {
		super();
		this.tel = tel;
		this.name = name;
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "tel=" + tel + ", name=" + name + ", address=" + address;
				
	}

	
}
