package step6;

import java.util.Scanner;

public class AddrMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name;
		String tel;
		String addr;
		int i = 0, c;

		boolean flag = true, flag1 = false;

		Addr[] a = new Addr[10];

		while (flag) {
			System.out.println("1.등록");
			System.out.println("2.검색");
			System.out.println("3.전체출력");
			System.out.println("4.수정");
			System.out.println("5.삭제");
			System.out.println("6.종료");
			c = sc.nextInt();

			switch (c) {
			case 1:

				System.out.print("이름: ");
				name = sc.next();
				System.out.print("전화번호: ");
				tel = sc.next();
				System.out.print("주소: ");
				addr = sc.next();

				Addr d = new Addr(name, tel, addr);
				a[i] = d;
				i++;
				break;

			case 2:

				System.out.print("이름: ");
				name = sc.next();
				flag1 = false;
				for (int j = 0; j < i; j++) {
					flag1 = a[j].search(name);
					if (flag1) {
						a[j].print();
						break;
					}
				}
				if (!flag1)
					System.out.println("없다.");
				break;

			case 3:
				for (int j = 0; j < i; j++) {
					a[j].print();
				}
				break;

			case 4:
				System.out.print("수정 이름: ");
				name = sc.next();
				System.out.print("수정 전화번호: ");
				tel = sc.next();
				System.out.print("수정 주소: ");
				addr = sc.next();

				boolean f = false;

				for (int j = 0; j < i; j++) {
					f = a[j].edit(name, tel, addr);

					if (f)
						break;
				}
				if (f == false)
					System.out.println("없다.");
				
			case 6:
				flag = false;
			}
		}
	}
}
