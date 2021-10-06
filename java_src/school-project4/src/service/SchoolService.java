package service;

import java.util.ArrayList;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import vo.Person;

public class SchoolService {

	private ArrayList<Person> list = new ArrayList<Person>();

	public void addPerson(Person p) throws DuplicateTelException {

		for (int i = 0; i < list.size(); i++) {
			Person per = list.get(i);
			if (p.getTel().equals(per.getTel())) {
				throw new DuplicateTelException("동일한 번호 존재");
			}
		}
		list.add(p);
	}

	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public Person findPerson(String tel) throws PersonNotFoundException {
		Person p = null;
		for (int i = 0; i < list.size(); i++) {
			Person per = list.get(i);
			if (per.getTel().equals(tel)) {
				p = per;
			}
		}
		if (p == null) {
			throw new PersonNotFoundException("찾는게 없어");
		} else {
			return p;
		}
	}

	public void deletePerson(String tel) throws PersonNotFoundException {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			Person per = list.get(i);
			if (per.getTel().equals(tel)) {
				list.remove(i);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new PersonNotFoundException("찾는 구성원 없어~");
		}
	}

	public void updatePerson(String tel, Person p) throws PersonNotFoundException {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			Person per = list.get(i);
			if (per.getTel().equals(p.getTel())) {
				list.set(i, p);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new PersonNotFoundException("찾는 구성원 없어~");
		}
	}
}
