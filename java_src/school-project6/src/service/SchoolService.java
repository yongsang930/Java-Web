package service;

import java.util.ArrayList;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import vo.Person;

public class SchoolService {

	private ArrayList<Person> list = new ArrayList<Person>();

	public void addPerson(Person p) throws DuplicateTelException {
		int i = findIndex(p.getTel());
		if (i == -1) {
			list.add(p);
		} else {
			throw new DuplicateTelException("동일한 번호 존재");
		}
	}

	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
		}
	}

	public Person findPerson(String tel) throws PersonNotFoundException {

		Person p = null;
		int i = findIndex(tel);
		if (i == -1)
			throw new PersonNotFoundException("찾는 구성원이 없음");
		p = list.get(i);
		return p;

	}
	
	
	public void deletePerson(String tel) throws PersonNotFoundException{
		int i = findIndex(tel);
		if(i== -1)
			throw new PersonNotFoundException("찾는 구성원이 없음");
		list.remove(i);
	}
	
	private int findIndex(String tel) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			if (p.getTel().equals(tel)) {
				index = i;
				break;
			}
		}
		return index;
	}
}
