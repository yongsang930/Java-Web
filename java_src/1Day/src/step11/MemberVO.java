package step11;

public class MemberVO {
	
	private int num;
	private String name;
	private String dept;
	private String address;
	
	public MemberVO(int num, String name, String dept, String address) {
		super();
		this.num = num;
		this.name = name;
		this.dept = dept;
		this.address = address;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "MemberVO [num=" + num + ", name=" + name + ", dept=" + dept + ", address=" + address + "]";
	}
	
}
