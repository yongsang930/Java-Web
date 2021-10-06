package step11;

public class DaoImpl2 implements Dao {

	private int index;
	private MemberVO[] p = new MemberVO[10];
	
	public void connect() {
		System.out.println("DaoImpl2이 접속했습니다.");
		
	}

	public void addPerson(MemberVO p) {
		this.p[index] = p;
		index++;
	}

	public void printAll() {
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}

	public MemberVO findPerson(String name) {
		MemberVO per = null;
		for (int i = 0; i < p.length; i++) {
			if(p[i].getName().equals(name)) {
				per = p[i];
			}
		}
		return per;
	}

}
