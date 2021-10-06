package vo;

public class Student extends Person{
	private String stuId;
	//Constructor, set/get, toString()
	public Student() {
		super();
	}

	public Student(String tel, String name, String address, String stuId) {
		super(tel, name, address);
		this.stuId = stuId;
	}


	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "stuId=" + stuId + ", getTel()=" + getTel()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress();
			
	}
	
}
