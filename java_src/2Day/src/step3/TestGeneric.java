package step3;

import java.util.ArrayList;
import java.util.Iterator;

public class TestGeneric {

	public static void main(String[] args) {
		
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(new Person("백박사",200));
		list.add(new Person("황정민",100));
		list.add(new Person("장박사",300));
		
		Iterator<Person> it = list.iterator();
		int total = 0;
		
		while(it.hasNext()) {
			total += it.next().getMoney();
		}
		System.out.println(total);
		System.out.println("********************");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		
		for (Person p : list) {
			System.out.println(p.getName());
		}
		
		//1.추가 2.검색 3.수정 4.삭제 5.전체출력 6.데이터초기화 7.종료
		//DTO Service Test
		
		//1 - 이름: a, 전화번호: 1, 주소: 지구
	}	
	
}
