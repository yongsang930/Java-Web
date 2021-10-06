import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		long timeStart;
		long timeEnd;
		timeStart = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list1.add(0, String.valueOf(i));
//			System.out.println(list1); // 0 / 1, 0 / 2, 1 ,0 이런식으로 입력됨
		}
		timeEnd = System.nanoTime();
		System.out.println("ArrayList 걸린 시간 : " + (timeEnd - timeStart) + "ns");
		timeStart = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list2.add(0, String.valueOf(i));
			System.out.println(list2);
		}
		timeEnd = System.nanoTime();
		System.out.println("LinkedList 걸린 시간 : " + (timeEnd - timeStart) + "ns");
	}
}