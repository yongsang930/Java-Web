package step10;

abstract public class Character {
	protected int hp;
	protected int level = 1;
	protected int energy;

	abstract public void eat();
	abstract public void sleep();
	abstract public boolean play();
	abstract public boolean train();
	abstract public void levelUp();

	public boolean checkEnergy() {
		if (energy <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printInfo() {
		System.out.println("\n재 캐릭터의 상태");
		System.out.println("체력: " + hp);
		System.out.println("에너지: " + energy);
		System.out.println("레벨: " + level + "\n");
	}
}
