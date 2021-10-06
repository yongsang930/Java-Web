package step4;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private int menu;

	boolean flag = true;

	private String menuStr = "1.추가 2.검색 3.수정 4.삭제 5.전체출력 6.데이터초기화 7.종료";

	public void menuProcess(ArrayList<Member> data) {
		int idx = 0;

		while (flag) {
			System.out.println(menuStr);
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				data.add(infoInput());
				break;
			case 2:
				idx = search(data);
				printMember(data.get(idx));
			case 3:
				editMember(data);
				break;
			case 4:
				delMember(data);
				break;
			case 5:
				for (idx = 0; idx < data.size(); idx++) {
					printMember(data.get(idx));
				}
			case 6:
				data.removeAll(data);
				break;
			case 7:
				System.out.println("프로그램 종료");
				flag = false;
				break;
			default:
				System.out.println("잘못입력");
			}
		}
	}

	public Member infoInput() {
		System.out.println("이름: ");
		String name = sc.next();
		System.out.println("전화번호 : ");
		String tel = sc.next();
		sc.nextLine();
		System.out.println("주소 : ");
		String address = sc.nextLine();
		return new Member(name, tel, address);
	}

	public int search(ArrayList<Member> data) {
		System.out.println("이름: ");
		String name = sc.next();

		for (int i = 0; i < data.size(); i++) {
			if (name.equals(data.get(i).getName())) {
				return i;
			}
		}
		return 0;
	}

	public void editMember(ArrayList<Member> data) {
		int idx = search(data);
		System.out.println("새 전화번호: ");
		String tel = sc.next();
		sc.nextLine();
		System.out.println("새 주소: ");
		String address = sc.nextLine();

		data.set(idx, new Member(data.get(idx).getName(), tel, address));
	}
	
	public void delMember(ArrayList<Member>data) {
		int idx = search(data);
		data.remove(idx);
	}
	
	public void printMember(Member m) {
		System.out.println(m);
	}
}
