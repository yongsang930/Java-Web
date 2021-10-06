package step7;

public class MemberVO {
	private String id;
	private String name;
	private String tel;
	private String addr;
	
	public MemberVO(String id, String name, String tel, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}


	public String getTel() {
		return tel;
	}


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	

}
