package vo;

public class Teacher extends Person{
	
	private String sub;
	// Person의 생성자를 오버라이딩하기 때문에 해당 클래스의 변수만 추가

	public Teacher(String tel, String name, String addr, String sub) {
	// 부모꺼를 가져오는 것이므로 부모것들 할당 된 후 자식 iv가 할당	
		super(tel, name, addr);
		this.sub = sub;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
	//부모의 메소드들을 오버라이딩(자기화)하여 출력	
		return "Teacher [sub=" + sub + ", getTel()=" + getTel() + ", getName()=" + getName() + ", getAddr()="
				+ getAddr() + "]";
	}
}
