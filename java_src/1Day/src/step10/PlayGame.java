package step10;

import java.util.Scanner;

public class PlayGame {
	
	private Character charac;
	private int categore;
	private boolean exit;
	
	
	public PlayGame(Character charac) {
		this.charac = charac;
	}
	
	public void printCate(Scanner sc) {
		System.out.println("--번호를 고르세요.--");
		System.out.println("1.밥을 먹읍시당");
		System.out.println("2.졸려...잠을 잘래!");
		System.out.println("3.놀자 놀자 나가놀자~");
		System.out.println("4.우리 운동하러 가자!");
		System.out.println("5.게임 종료");
		System.out.println("----------------");
		System.out.print("\n번호:");
		categore = sc.nextInt();
		play();
	}
	
	public void play() {
		switch(categore) {
		case 1:
			charac.eat();
			break;
		case 2:
			charac.sleep();
			break;
		case 3:
			exit = charac.play();
			break;
		case 4:
			exit = charac.train();
			break;
		case 5:
			exit = true;
		}
		charac.printInfo();
	}

	public Character getCharac() {
		return charac;
	}

	public void setCharac(Character charac) {
		this.charac = charac;
	}

	public int getCategore() {
		return categore;
	}

	public void setCategore(int categore) {
		this.categore = categore;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
