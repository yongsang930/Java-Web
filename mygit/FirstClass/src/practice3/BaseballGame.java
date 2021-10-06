package practice3;

import java.util.Scanner;


public class BaseballGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] numRan = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int j = 0;
		int tmp = 0;
		
			for (int i = 0; i < numRan.length; i++) {
				j = (int) (Math.random() * 9);

				tmp = numRan[i];
				numRan[i] = numRan[j];
				numRan[j] = tmp;

			}
		 
//		password(numRan);
		
		int round = 0;

		System.out.printf("※게임 진행 방법: 세 자리의 숫자를 띄어쓰기로 구분하여 입력 후 Enter키를 누르세요.%n%n");
		
		while (true) {

			int ball = 0;
			int strike = 0;
			    round++;
			    
			if(round % 2 == 0)
			System.out.printf("-----Round " + round +  "-----%n" + "'예솔'이는 번호를 입력하세요!%n입력: ");
			else 
			System.out.printf("-----Round " + round +  "-----%n" + "'용상'이는 번호를 입력하세요!%n입력: ");
				

			int[] innum = { scan.nextInt(), scan.nextInt(), scan.nextInt() };

			for (int i = 0; i < 3; i++) {
				for (int p = 0; p < 3; p++) {
					if (numRan[i] != innum[i] && numRan[i] == innum[p]) {
						ball++;
					}
				}
			}

			for (int i = 0; i < 3; i++) {
					if (numRan[i] == innum[i]) {
						strike++;
					}
			}

			System.out.printf("strike : %d, ball : %d%n%n", strike, ball);

			if (strike == 3) {
				password(numRan);
				System.out.println("게임 종료!!!");
				scan.close();
				break;
			}
		}
	}

	static void password(int[] n) {
		System.out.print("정답: ");
		for (int i = 0; i < 3; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
}
