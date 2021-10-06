package step6;

public class Addr {

	private String name;
	private String tel;
	private String addr;


	public Addr(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	
	public boolean search(String name) {
		if(this.name.equals(name)) {
			return true;
		}
		else return false;
	}
	
	public void print() {
		System.out.print("이름: " + name);
		System.out.print("전화번호: " + tel);
		System.out.print("주소: " + addr);
	}
	
	public boolean edit(String name, String tel, String addr) {
		boolean f ;
		f = search(name);
		
		if(f==true) {
			this.tel = tel;
			this.addr = addr;
		}
		return f;
	}
}
