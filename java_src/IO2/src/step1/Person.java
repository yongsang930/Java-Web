package step1;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;
	private transient String password; // 직렬화에서 제외하겠다
	private String addr;

	public Person(String name, String password, String addr) {
		super();
		this.name = name;
		this.password = password;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "TestObjectOutput [name: " + name + ", password: " + password + ", addr: " + addr + "]";
	}
}
