import java.util.Scanner;

public class Math1_1430 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String str = String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt());
		sc.close();

		String[] num = str.split("");

		int[] cnt = new int[10]; //0 ~ 9 출력

		for (int i = 0; i < num.length; i++) {
			if (num[i].equals("0")) {
				cnt[0]++;
			} else if (num[i].equals("1")) {
				cnt[1]++;
			} else if (num[i].equals("2")) {
				cnt[2]++;
			} else if (num[i].equals("3")) {
				cnt[3]++;
			} else if (num[i].equals("4")) {
				cnt[4]++;
			} else if (num[i].equals("5")) {
				cnt[5]++;
			} else if (num[i].equals("6")) {
				cnt[6]++;
			} else if (num[i].equals("7")) {
				cnt[7]++;
			} else if (num[i].equals("8")) {
				cnt[8]++;
			} else if (num[i].equals("9")) {
				cnt[9]++;
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
}
