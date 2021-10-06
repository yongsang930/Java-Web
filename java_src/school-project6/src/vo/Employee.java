package vo;

public class Employee extends Person {
	private String dept;
	//Constructor, set/get, toString()

	public Employee(String tel, String name, String address, String dept) {
		super(tel, name, address);
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
		return "dept=" + dept + ", getTel()=" + getTel()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress();
				
	}

}
