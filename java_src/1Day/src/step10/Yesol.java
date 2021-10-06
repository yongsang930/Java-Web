package step10;

public class Yesol extends Character {
	
	public Yesol() {
		hp = 30;
		energy = 35;
		System.out.println("\n김예솔이 생성되었습니다.\n");
		
		printInfo();
	}
	
	public void eat() {
		energy +=10;
	}

	public void sleep() {
		energy +=5;
	}

	public boolean play() {
		energy -=5;
		hp +=15;
		levelUp();
		return checkEnergy();
	}

	public boolean train() {
		energy -=15;
		hp +=20;
		levelUp();
		return checkEnergy();
		
	}

	public void levelUp() {
		if( 45<= hp) {
			level++;
			hp -= 35;
		}
	}
}
