package Practice6_5;

// 변수 종류 구분하기
public class PlayingCard {
	int kind;      //인스턴스 변수
	int num;       //인스턴스 변수
	
	static int width;     //static변수 / 클래스 변수 
	static int height;    //static변수 / 클래스 변수
	
	PlayingCard(int k, int n) {  // 인스턴스 메서드
		kind = k;                // 인스턴스 변수 = 지역변수
		num = n;                 // 인스턴스 변수 = 지역변수
	}
	public static void main(String[] args) {    // static 메서드, args는 지역변수
		PlayingCard card = new PlayingCard(1, 1);  // main 메서드, 객체생성 및 실행 / 괄호안은 매개변수
	}
}
