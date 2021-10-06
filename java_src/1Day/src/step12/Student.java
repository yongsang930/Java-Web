package step12;

public class Student extends Person{


	private String Stuid;
	
	public Student(String tel, String name, String address, String Stuid) {
		super(tel, name, address);
		this.Stuid = Stuid;
	}

	public String getStuid() {
		return Stuid;
	}

	public void setStuid(String stuid) {
		Stuid = stuid;
	}

	public String toString() {
		return super.toString() + "Stuid" + Stuid;
	}
}
