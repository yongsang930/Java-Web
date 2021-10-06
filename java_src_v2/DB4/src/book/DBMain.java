 package book;

import java.util.Scanner;

public class DBMain {

	public static void main(String[] args) {
		DB d = new DB();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		int i = 0;

		while (flag) {
			System.out.println("1.도서목록 추가 2.도서목록 출력 3.제목 책 검색 4.할인된 가격 조회 5.도서구매 6.종료");
			i = sc.nextInt();

			switch (i) {
			case 1:
				d.bookInsert();
				break;
			case 2:
				d.bookPrint();
				break;
			case 3:
				System.out.print("검색할 책의 제목: ");
				String title = sc.next();
				d.bookSearch(title);
				break;
			case 4:
				System.out.print("가격 조회할 책의 제목: ");
				String title2 = sc.next();
				d.bookDiscount(title2);
				break;
			case 5:
				System.out.print("구매할 책의 제목: ");
				String title3 = sc.next();
				d.bookBuy(title3);
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("잘못 입력");
			}
		}
	}
}