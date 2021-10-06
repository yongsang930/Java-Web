package step1;

import java.util.ArrayList;

public class TestList1 {

	public static void main(String[] args) {
			
		ArrayList list = new ArrayList();
		list.add("아이유");
		list.add("나연");
		list.add("사나");
		list.add("사나");
		
		System.out.println(list.size()); // 전체 데이터 수 출력
		System.out.println(list);  // 원래는 주소값 16진수지만 toString() 포함되어있으니 목록이 출력
		
		System.out.println(list.get(0)); // 인덱스 위치에 값 출력
		
		list.add(1); // 맨뒤에 값 추가
		list.remove(3); // 인덱스 값 삭제
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
