package vo;

public class Employee extends member {

	private String job;

	public Employee() {
		super();
	}

	public Employee(String id, String name, String tel, String addr, int type, String job) {
		super(id, name, tel, addr, type);
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "employee [job=" + job + ", id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + ", type="
				+ type + "]";
	}

}
//| 아이디: " + id + "| 이름: " + name + "| 전화번호: " + tel + "| 주소: " + addr + "| 타입: " + type + " |