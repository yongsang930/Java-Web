package step1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<String> a1 = new ArrayList<String>(); // 문자열만 받겠다는 선언

		a1.add("aaa");
//		a1.add(aa); String이 아님
		a1.add("bbb");
		a1.add(1, "ccc"); // 1번 인덱스로 "ccc"가 들어가면서 "bbb"가 2번 인덱스로 한 칸 밀림
		a1.add(2, "ddd"); // 2번 인덱스로 "ddd"가 들어가면서 "bbb"가 3번 인덱스로 한 칸 밀림
		System.out.println(a1);

		for (int i = 0; i < a1.size(); i++) {
			System.out.println(i + "번째 요소 :" + a1.get(i));
		}

		System.out.println("검색할 값을 입력해: ");
		String srh = sc.next();
		int idx = 0;

		if (a1.contains(srh)) {
			idx = a1.indexOf(srh);
			System.out.println(idx + "번 인덱스에서 \"" + a1.get(idx) + "\"를 찾음");
		} else {
			System.out.println("찾는 값이 없음");
		}
		
		System.out.println("삭제할 값을 입력해: ");
		srh = sc.next();
		idx = 0;

		if (a1.contains(srh)) {
			idx = a1.indexOf(srh);
			a1.remove(idx);
		} else {
			System.out.println("찾는 값이 없음");
		}
		
		for (int i = 0; i < a1.size(); i++) {
			System.out.println(i + "번 인덱스의 " + a1.get(i));
		}
		
		System.out.println("전체삭제");
		a1.removeAll(a1);
		
		if(a1.isEmpty()) {
			System.out.println("리스트가 비었음");
		}else {
			for (int i = 0; i < a1.size(); i++) {
				System.out.println(i + "번 인덱스의 " + a1.get(i));
			}
		}

	}
}
