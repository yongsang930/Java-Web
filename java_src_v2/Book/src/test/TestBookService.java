package test;

import java.util.Scanner;

import service.BookDAO;
import vo.BookVO;

public class TestBookService {
	public static void main(String[] args) {

		BookDAO b = new BookDAO();

		Scanner sc = new Scanner(System.in);

		String id;
		String title;
		String publisher;
		int price;

		boolean flag = true;

		while (flag) {
			System.out.println("1.등록 2.검색 3.수정");
			int i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.print("저자를 입력: ");
				id = sc.next();
				System.out.print("제목을 입력: ");
				title = sc.next();
				System.out.print("출판사를 입력: ");
				publisher = sc.next();
				System.out.print("가격을 입력: ");
				price = sc.nextInt();

				BookVO bvo = new BookVO(id, title, publisher, price);

				b.bookinsert(bvo);
				break;
			case 2:
				System.out.print("저자를 입력: ");
				id = sc.next();
				BookVO bb = b.booksearch(id);
				System.out.println(bb);
				break;
			
			case 3:
				System.out.print("저자를 입력: ");
				id = sc.next();
				System.out.print("수정할 제목을 입력: ");
				title = sc.next();
				System.out.print("수정할 출판사를 입력: ");
				publisher = sc.next();
				System.out.print("수정할 가격을 입력: ");
				price = sc.nextInt();
				
				BookVO bvo2 = new BookVO(id, title, publisher, price);
				b.bookupdate(bvo2);
				break;
			default:
				System.out.println("잘못 입력");
				
			}
		}
	}
}