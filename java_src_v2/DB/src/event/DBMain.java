package event;

import java.util.Scanner;

public class DBMain {

	public static void main(String[] args) {

		DB d = new DB();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int i;

		while (flag) {
			System.out.println("1.등록 2.명단확인 3.검색 4.수정 5.삭제");
			System.out.print("번호: ");
			i = sc.nextInt();

			switch (i) {
			case 1:

				d.enroll();
				break;
			case 2:
				d.print();
				break;
			case 3:
				System.out.print("검색할 번호를 입력: ");
				int num = sc.nextInt();
				d.search(num);
				break;
			case 4:
				System.out.println("수정할 번호를 입력: ");
				int j = sc.nextInt();
				System.out.println("수정할 이메일을 입력:");
				String email = sc.next();
				d.search(j);
				d.update(j, email);
				break;
			case 5:
				System.out.print("삭제할 번호를 입력: ");
				int h = sc.nextInt();
				d.delete(h);
				break;
			default:
				System.out.println("잘못 입력");
			}
		}
	}
}
