package Practice6_20;

import java.util.Arrays;

public class Exercise6_20 {
	
	static int max(int[] arr) {
		if(arr == null || arr.length == 0)
			return -999999;
		
		Arrays.sort(arr);
		
		
		return arr[arr.length-1];
	}
	
	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(Arrays.toString(data));
		System.out.println("최대값: " + max(data));
		System.out.println("최대값: " + max(null));
		System.out.println("최대값: " + max(new int[] {}));
	}
}
