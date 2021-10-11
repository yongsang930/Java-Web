package test;

import java.util.Scanner;

import service.Service;
import service.ServiceImpl;
import vo.AccountVO;

public class TestBookService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String accountNumber = null;
		String accountName = null;
		int balance = 0;

		boolean flag = true;
		Service service = new ServiceImpl();

		while (flag) {
			System.out.println("1.개좌개설 2.계좌조회 3.입금 4.출금 5.잔액조회 6.평균잔액 7.종료");
			int i = sc.nextInt();

			switch (i) {
			case 1:
				System.out.print("계좌번호 입력: ");
				accountNumber = sc.next();
				System.out.print("고객명 입력: ");
				accountName = sc.next();
				System.out.print("가격 입력: ");
				balance = sc.nextInt();

				service.insertAccount(new AccountVO(accountNumber, accountName, balance));

				break;
			case 2:
				System.out.print("계좌번호 입력: ");
				accountNumber = sc.next();
				AccountVO vo = service.findAccount(accountNumber);
				System.out.println(vo);
				break;
			case 3:
				System.out.print("계좌번호 입력: ");
				accountNumber = sc.next();
				System.out.print("가격 입력: ");
				balance = sc.nextInt();

				int money = service.depositMoney(accountNumber, balance);
				System.out.println(money + "원이 입금되었습니다.");
				break;
			case 4:
				System.out.print("계좌번호 입력: ");
				accountNumber = sc.next();
				System.out.print("가격 입력: ");
				balance = sc.nextInt();

				service.withDrawMoney(accountNumber, balance);
				break;
			case 5:
				System.out.print("이름 입력: ");
				accountName = sc.next();
				int sum = service.sumAccount(accountName);
				System.out.println(sum);
				break;
			case 6:
				System.out.print("이름 입력: ");
				accountName = sc.next();
				int avg = service.avgAccount(accountName);
				System.out.println(avg);
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("입력 오류");
			}

		}
	}
}
