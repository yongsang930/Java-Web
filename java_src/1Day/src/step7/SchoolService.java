package step7;

public class SchoolService {
	private int index;
	private MemberVO[] p = new MemberVO[10];

	public void addPerson(MemberVO p) {

		this.p[index] = p;
		index++;

	}

	public void print() {
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}

	public MemberVO findPerson(String tel) {
		MemberVO per = null;

		for (int i = 0; i < p.length; i++) {
			if (p[i].getTel().equals(tel))
				per = p[i];
		}
		return per;
	}
}
