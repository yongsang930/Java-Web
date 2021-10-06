package Practice7_1;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		int num = 1;
		int cnt = 0;

		for (int i = 0; i < cards.length; i++) { // i%10+1로 값넣어줘도 됨
			cards[i] = new SutdaCard();
			cards[i].num = num;
			cards[i].isKwang = false;

			if (cards[i].num == 1 || cards[i].num == 3 || cards[i].num == 8) {
				cnt++;
				cards[i].isKwang = (cnt <= 3) ? !cards[i].isKwang : false;
			}
			num++;
			if (num == 11)
				num = 1;
		}
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : " ");
	}
}

public class Exercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();

		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
	}
}
