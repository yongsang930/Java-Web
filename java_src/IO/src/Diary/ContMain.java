package Diary;

import java.io.IOException;
import java.util.Scanner;

public class ContMain {

	public static void main(String[] args) throws IOException {
		
		Cont c = new Cont();
		
		Scanner sc = new Scanner(System.in);
		
		int i;
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.읽기 | 2.쓰기 | 3.종료");
			i = sc.nextInt();
			
			switch (i) {
			case 1: 
				c.read();
				break;
			case 2: 
				c.write();
				break;
			case 3: 
				System.out.println("프로그램을 종료합니다");
				sc.close();
				break;
			}
		}
	}
}
