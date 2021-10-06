package vo;

public class Student extends Person{
	
	private String stuID;
	
	public Student(String name, String tel, String addr, String stuID) {
		super(name, tel, addr);
		this.stuID = stuID;
	}

	public String getSubject() {
		return  stuID;
	}

	public void setSubject(String subject) {
		this. stuID = subject;
	}

	@Override
	public String toString() {
		return "Student [stuID: " + stuID + "]";
	}
}
