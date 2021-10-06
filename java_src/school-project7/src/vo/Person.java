package vo;

import java.io.Serializable;


public class Person implements Serializable{ 
	//공통사항 즉, 공동으로 상속해줄 변수설정 / 직렬화를 위한 인터페이스 설정

	private String tel;
	private String name;
	private String addr;
	//  직렬화에 제외시킬 iv는 transient를 변수 타입 앞에 붙여줌

	public Person(String tel, String name, String addr) { 
    // 생성자는 한번 호출하면 끝임 / 수정변경을 위해선 set메소드로 설계
		super();
		this.tel = tel;
		this.name = name;
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Person [tel=" + tel + ", name=" + name + ", addr=" + addr + "]";
	}
}
