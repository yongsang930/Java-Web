package step10;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Character ch = null;
		PlayGame gp = null;

		System.out.println("캐릭터를 선택해주세요 :)");
		System.out.print("1.박용상 2.김예솔 3.김내순\n번호: ");

		int x = sc.nextInt();

		switch (x) {
		case 1:
			ch = new Yongsang();
			break;
		case 2:
			ch = new Yesol();
			break;
		case 3:
			ch = new Naesoon();
			break;
		default :
			System.out.println("잘못 입력했어요! 다시 입력하세요!");
		}
		
		if(ch == null) {
			System.out.println("게임종료");
			return;
		}else {
			gp = new PlayGame(ch);
		}
		
		while(true) {
			gp.printCate(sc);
			
			if(gp.isExit()) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}
}
