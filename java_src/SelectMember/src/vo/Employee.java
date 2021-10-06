package vo;

public class Employee extends Person{

	private String dept;
	
	public Employee(String name, String tel, String addr, String dept) {
		super(name, tel, addr);
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
		return "Employee [dept: " + dept + "]";
	}
}
