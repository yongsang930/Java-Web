package step10;

public class Yongsang extends Character {
	
	public Yongsang() {
		hp = 20;
		energy = 30;
		System.out.println("\n박용상이 생성되었습니다.\n");
		
		printInfo();
	}
	
	public void eat() {
		energy +=5;
	}

	public void sleep() {
		energy +=10;
	}

	public boolean play() {
		energy -=10;
		hp +=15;
		levelUp();
		return checkEnergy();
	}

	public boolean train() {
		energy +=5;
		hp +=20;
		levelUp();
		return checkEnergy();
		
	}

	public void levelUp() {
		if( 40<= hp) {
			level++;
			hp -= 35;
		}
	}
}
