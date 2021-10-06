package Practice6_18;

// 기본적인 조건식을 외우고 있는것이 좋을 듯
public class Excercise6_18 {

	static boolean isNumber(String str) {
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch <= '9' && ch >= '0') {
				cnt++;
			}
		}
		if (cnt == str.length())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));
	}
}
