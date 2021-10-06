package service;

import java.util.ArrayList;

import vo.Person;
import vo.Student;
import exception.DuplicateTelException;
import exception.PersonNotFoundException;

public class SchoolService {
	private ArrayList list = new ArrayList();

	/**
	 * 학교 구성원을 추가하는 메서드 동일한 번호의 구성원이 추가되려고 하면 DuplicateTelException을
	 * 발생(throw)시키고 throws 한다.
	 */

	// throw, throws

	public void addPerson(Person p) throws DuplicateTelException {
		int i = findIndex(p.getTel());
		if (i == -1) {
			list.add(p);
		} else {
			throw new DuplicateTelException("동일한 번호가 존재하여 추가할수 없습니다.");
		}
	}// add

	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			Person per = (Person) list.get(i);
			System.out.println(list.get(i));
		}
	}

	public Person findPerson(String tel) throws PersonNotFoundException {
		Person p = null;
		int i = findIndex(tel);// 인덱스이고
		if (i == -1)
			throw new PersonNotFoundException("찾는 구성원이 없습니다.");
		p = (Person) list.get(i);
		return p;// else는 안써도된다 exception 나면 바로 코드가 끝나버리므로

	}

	public void deletePerson(String tel) throws PersonNotFoundException {
		int i = findIndex(tel);
		if (i == -1) 
			throw new PersonNotFoundException("삭제할 구성원이 없습니다.");
		list.remove(i);
		

	}

	public void updatePerson(String tel, Person p)
			throws PersonNotFoundException {
		int i = findIndex(tel);
		if (i == -1)
			throw new PersonNotFoundException("수정할 사람이 없습니다.");
		list.set(i, p);
	}

	// tel에 일치되는 리스트 내부의 구성원 존재 유무- addPerson()
	// tel에 일치되는 리스트 내부의 구성원의 인덱스 - find, delete, updatePerson()
	/**
	 * 매개변수로 넘어온 번호와 리스트의 내부요소의 번호를 비교하여 같은 번호의 요소가 없으면 -1이 반환 add는 -1이면 추가 같은
	 * 번호가 있으면 해당 인덱스를 반환한다.
	 */
	private int findIndex(String tel) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			Person per = (Person) list.get(i);
			if (per.getTel().equals(tel)) {
				index = i;
				break;
			}
		}
		return index;
	}
}
