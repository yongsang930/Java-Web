package step12;

public class Teacher extends Person{

	private String Subject;
	
	public Teacher(String tel, String name, String address, String Subject) {
		super(tel, name, address);
		this.Subject = Subject;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	@Override
	public String toString() {
		return super.toString() + "Subject" + Subject;
	}
}
