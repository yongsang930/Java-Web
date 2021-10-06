package step7;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String id;
		String name;
		String tel;
		String addr;

		boolean flag = true;

		int i = 0;

		SchoolService sv = new SchoolService();

		while (flag) {
			System.out.println("1.등록 ");
			System.out.println("2.검색 ");
			System.out.println("3.전체출력 ");
			System.out.println("4.종료 ");

			i = sc.nextInt();

			switch (i) {
			case 1:
				System.out.print("아이디: ");
				id = sc.next();
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("전화번호: ");
				tel = sc.next();
				System.out.print("주소: ");
				addr = sc.next();

				sv.addPerson(new MemberVO(id, name, tel, addr)); // 이 부분 헷갈림
				break;

			case 2:
				System.out.print("전화번호 입력: ");
				tel = sc.next();

				MemberVO m = sv.findPerson(tel);
			case 3:
				sv.print();
				break;
			case 4:
				System.out.println("프로그램 종료");
				flag = false;
				break;
			default:
				System.out.println("입력이 잘 못 되었습니다. 재입력하세요.");
			}
		}
		sc.close();
	}
}
