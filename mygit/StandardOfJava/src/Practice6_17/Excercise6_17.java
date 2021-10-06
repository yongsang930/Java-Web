package Practice6_17;

import java.util.Arrays;

public class Excercise6_17 {

	static int[] shuffle(int[] arr) {

		int tmp;
		int num;

		for (int i = 0; i < arr.length; i++) {
			num = (int) (Math.random() * arr.length);
			tmp = arr[i];
			arr[i] = arr[num];
			arr[num] = tmp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
	}
}
