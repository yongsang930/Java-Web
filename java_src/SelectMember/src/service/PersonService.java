package service;

import java.util.ArrayList;

import vo.Person;

public class PersonService {

	/**
	 * 상품 관리 비지니스 로직을 담당하는 클래스
	 */
	private ArrayList<Person> list = new ArrayList<Person>();

	public void addPerson(Person p) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			Person m = list.get(i);
			if (p.getTel().equals(m.getTel()))
				flag = true;
			break;
		}
		if (flag == false)
			list.add(p);
		else
			System.out.println("이미 등록된 전화번호 입니다.");
	}

	public void printAll() {
		System.out.println(list);
	}

	public Person findPerson(String tel) {
		Person pro = null;
		for (int i = 0; i < list.size(); i++) {
			Person pro1 = (Person) list.get(i);
			if (tel.equals(pro1.getTel())) {
				pro = pro1;
			}
		}
		return pro;
	}

	public void deletePerson(String tel) {
		for (int i = 0; i < list.size(); i++) {
			Person pro1 = (Person) list.get(i);
			if (tel.equals(pro1.getTel())) {
				list.remove(i);
			}
		}
	}

	public boolean updatePerson(Person memberVO) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			Person Mem = (Person) list.get(i);
			if (Mem.getTel().equals(memberVO.getTel())) {
				list.set(i, memberVO);
				flag = true;
				break;
			}
		}
		return flag;
	}

}
