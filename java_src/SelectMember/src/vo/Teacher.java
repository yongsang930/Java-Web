package vo;

public class Teacher extends Person {

	private String subject;

	public Teacher(String name, String tel, String addr, String subject) {
		super(name, tel, addr);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [subject: " + subject + "]";
	}
}
