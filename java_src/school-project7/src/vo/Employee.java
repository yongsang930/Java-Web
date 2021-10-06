package vo;

public class Employee extends Person {

	private String dept;
	// Person의 생성자를 오버라이딩하기 때문에 해당 클래스의 변수만 추가

	public Employee(String tel, String name, String addr, String dept) {
	// 부모꺼를 가져오는 것이므로 부모것들 할당 된 후 자식 iv가 할당
		super(tel, name, addr);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
	//부모의 메소드들을 오버라이딩(자기화)하여 출력
		return "Employee [dept=" + dept + ", getTel()=" + getTel() + ", getName()=" + getName() + ", getAddr()="
				+ getAddr() + "]";
	}
}
