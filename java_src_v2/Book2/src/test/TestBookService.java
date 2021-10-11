package test;

import java.util.Scanner;

import service.BookService;
import vo.BookVO;

public class TestBookService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// ArrayList<MemberVO> list =new ArrayList<MemberVO>();
		String id;
		String title;
		String author;
		String publisher;
		int price;

		boolean flag = true;
		int i = 0;
		//BookDAO service = new BookDAO();
		BookService service = new BookService();
		while (flag) {

			System.out.println("1.등록");
			System.out.println("2.검색");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.전체출력");
			System.out.println("6.종료");
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("아이디를 입력하세요 :");
				id = sc.next();
				System.out.println("책이름을 입력하세요 :");
				title = sc.next();
				System.out.println("저자를 입력하세요 :");
				author = sc.next();
				System.out.println("출판사를  입력하세요 :");
				publisher = sc.next();
				System.out.println("가격을 입력하세요 :");
				price = sc.nextInt();
				service.insert(new BookVO(id, title, author, publisher, price));
				break;
			case 2:
				System.out.println("아이디를 입력하세요 :");
				id = sc.next();
				BookVO m = service.findbook(id);

				System.out.println(m);
				break;

			case 3:
				System.out.println("수정할 id를 입력하세요 : ");
				id = sc.next();
				System.out.println("수정할 책이름을 입력하세요 :");
				title = sc.next();
				System.out.println("수정할 저자를 입력하세요 :");
				author = sc.next();
				System.out.println("수정할 출판사를 입력하세요 :");
				publisher = sc.next();
				System.out.println("수정할 가격을 입력하세요 :");
				price = sc.nextInt();
				BookVO m2 = new BookVO(id, title, author, publisher, price);
				service.updatebook(m2);
				break;

			case 4:
				
				
				System.out.println("삭제할 id를 입력하세요 : ");
				id = sc.next();
				service.deletebook(id);
				break;

			case 5:
				
				service.printAll();
				
				
				break;
			case 6:
				flag = false;
				break;

			default:
				System.out.println("잘못 입력했어요 다시 입력하세요 ");
			}

		}

	}

}
