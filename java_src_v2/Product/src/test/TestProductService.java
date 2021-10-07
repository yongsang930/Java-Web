package test;

import java.util.Scanner;

import service.ProductDao;
import vo.Product;

public class TestProductService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int p_id;
		String p_name;
		int num;
		String co;
		int price;

		boolean flag = true;
		int i = 0;

		ProductDao service = new ProductDao();

		while (flag) {
			System.out.println("1.등록 2.명단확인 3.검색 4.수정 5.삭제 6.종료");
			i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.print("품번 입력: ");
				p_id = sc.nextInt();
				System.out.print("품명 입력: ");
				p_name = sc.next();
				System.out.print("수량 입력: ");
				num = sc.nextInt();
				System.out.print("제조사 입력: ");
				co = sc.next();
				System.out.print("가격 입력: ");
				price = sc.nextInt();

				service.insert(new Product(p_id, p_name, num, co, price));
				break;
			case 2:
				System.out.println(service.printAll());
				break;
			case 3:
				System.out.print("품번 입력: ");
				p_id = sc.nextInt();
				Product p = service.seadchProduct(p_id);
				System.out.println(p);
				break;
			case 4:
				System.out.print("품번 입력: ");
				p_id = sc.nextInt();
				System.out.print("수정될 품명 입력: ");
				p_name = sc.next();
				System.out.print("수정할 수량 입력: ");
				num = sc.nextInt();
				System.out.print("수정할 제조사 입력: ");
				co = sc.next();
				System.out.print("수정할 가격 입력: ");
				price = sc.nextInt();

				Product m2 = new Product(p_id, p_name, num, co, price);
				service.updateProduct(m2);
				break;
			case 5:
				System.out.print("삭제할 품번 입력: ");
				p_id = sc.nextInt();
				service.delete(p_id);
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
