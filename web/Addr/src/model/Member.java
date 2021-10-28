package model;

public class Member {
	private int num;
	private String name;
	private String tel;
	private String address;
	private int postal;

	public Member() {
		super();
	}

	public Member(int num, String name, String tel, String address, int postal) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.postal = postal;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostal() {
		return postal;
	}

	public void setPostal(int postal) {
		this.postal = postal;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + ", address=" + address + ", postal=" + postal
				+ "]";
	}
}
