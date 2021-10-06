package step4;

import java.util.ArrayList;

public class MemberMain {

	public static void main(String[] args) {
		ArrayList<Member> data = new ArrayList<Member>();
		MemberMenu mm = new MemberMenu();
		mm.menuProcess(data);
	}
}
