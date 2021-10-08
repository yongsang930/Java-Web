package test;

import java.util.ArrayList;
import java.util.Scanner;

import service.ServiceImpl;
import vo.Member;

public class addrDBMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ServiceImpl service = new ServiceImpl();
		boolean flag = true, flag2 = false;
		int menu, i;
		String name = null;
		String tel = null;
		String address = null;

		ArrayList<Member> list = null;

		while (flag) {
			System.out.println("1.등록 2.명단확인 3.검색 4.수정 5.삭제 6.종료");
			i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("전화번호: ");
				tel = sc.next();
				System.out.print("주소: ");
				address = sc.next();

				Member m = new Member(name, tel, address);
				flag2 = service.addMember(m);
				if (flag2) {
					System.out.println("정상처리");
				} else {
					System.out.println("비정상 처리");
				}
				break;
			case 2:
				list = service.getMember();
				for (int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j));
				}
				break;
			case 3:
				System.out.print("이름: ");
				name = sc.next();
				Member m2 = service.getMember(name);
				if (m2 == null) {
					System.out.println("검색 결과가 없음");
				} else {
					System.out.println(m2);
				}
				break;
			case 4:
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("수정될 전화번호: ");
				tel = sc.next();
				System.out.print("수정될 주소: ");
				address = sc.next();

				Member m3 = new Member(name, tel, address);
				flag2 = service.editMember(m3);
				if (flag2) {
					System.out.println("정상처리");
				} else {
					System.out.println("비정상 처리");
				}

				break;
			case 5:
				System.out.print("삭제할 사람의 이름: ");
				name = sc.next();
				flag2 = service.delMember(name);
				if (flag2) {
					System.out.println("정상처리");
				} else {
					System.out.println("비정상 처리");
				}
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("잘못 입력");
			}
		}
	}
}
