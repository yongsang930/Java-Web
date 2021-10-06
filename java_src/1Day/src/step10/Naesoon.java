package step10;

public class Naesoon extends Character {

	public Naesoon() {
		hp = 20;
		energy = 35;
		System.out.println("\n김내순이 생성되었습니다.\n");

		printInfo();
	}

	public void eat() {
		energy += 15;
	}

	public void sleep() {
		energy += 10;
	}

	public boolean play() {
		energy -= 10;
		hp += 10;
		levelUp();
		return checkEnergy();
	}

	public boolean train() {
		energy -= 10;
		hp += 20;
		levelUp();
		return checkEnergy();
	}

	public void levelUp() {
		if (40 <= hp) {
			level++;
			hp -= 35;
		}
	}
}
