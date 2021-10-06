import java.util.Scanner;

public class practice8 {

	public static void main(String[] args) {
		boolean run = true;
		
		int balance = 0;
		int money = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");

			int choice = scan.nextInt();
			
			if(choice == 1) {
				System.out.print("예금액> ");
				balance += scan.nextInt();
			} else if ( choice == 2) {
				System.out.print("출금액> ");
				balance -= scan.nextInt();
			} else if ( choice == 3) {
				System.out.print("잔고> ");
				System.out.println(balance);
			} else {
				scan.close();
				System.out.println("예솔이의 통장잔고가 바닥났어요.");
				run = false;
			}
		}
	}
}
