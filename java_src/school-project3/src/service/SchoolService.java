package service;

import java.util.HashMap;
import java.util.Iterator;
import vo.Person;

public class SchoolService {

	private HashMap map = new HashMap();

	public void addPerson(Person p) {
		if (map.containsKey(p.getTel())) {
			System.out.println(p.getTel() + "동일한 번호 있음");
		} else {
			map.put(p.getTel(), p);
		}
	}

	public void printAll() {
		Iterator it = map.values().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public Person findPerson(String tel) {
		Person p = (Person)map.get(tel);
		
		return p;
	}

	public void deletePerson(String tel) {
		map.remove(tel);
	}
	
	// 업데이트할 번호가 map에 key로 존재한다면
	// 삭제 후 추가
	public void updatePerson(String tel, Person p) {
		if(map.containsKey(tel)) {
			map.remove(tel);
			this.addPerson(p);
		}else {
			System.out.println("update할 필요가 없음");
			
		}
	}
}
