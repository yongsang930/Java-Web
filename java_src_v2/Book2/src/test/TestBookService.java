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

			System.out.println("1.���");
			System.out.println("2.�˻�");
			System.out.println("3.����");
			System.out.println("4.����");
			System.out.println("5.��ü���");
			System.out.println("6.����");
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("���̵� �Է��ϼ��� :");
				id = sc.next();
				System.out.println("å�̸��� �Է��ϼ��� :");
				title = sc.next();
				System.out.println("���ڸ� �Է��ϼ��� :");
				author = sc.next();
				System.out.println("���ǻ縦  �Է��ϼ��� :");
				publisher = sc.next();
				System.out.println("������ �Է��ϼ��� :");
				price = sc.nextInt();
				service.insert(new BookVO(id, title, author, publisher, price));
				break;
			case 2:
				System.out.println("���̵� �Է��ϼ��� :");
				id = sc.next();
				BookVO m = service.findbook(id);

				System.out.println(m);
				break;

			case 3:
				System.out.println("������ id�� �Է��ϼ��� : ");
				id = sc.next();
				System.out.println("������ å�̸��� �Է��ϼ��� :");
				title = sc.next();
				System.out.println("������ ���ڸ� �Է��ϼ��� :");
				author = sc.next();
				System.out.println("������ ���ǻ縦 �Է��ϼ��� :");
				publisher = sc.next();
				System.out.println("������ ������ �Է��ϼ��� :");
				price = sc.nextInt();
				BookVO m2 = new BookVO(id, title, author, publisher, price);
				service.updatebook(m2);
				break;

			case 4:
				
				
				System.out.println("������ id�� �Է��ϼ��� : ");
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
				System.out.println("�߸� �Է��߾�� �ٽ� �Է��ϼ��� ");
			}

		}

	}

}
