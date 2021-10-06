package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import vo.Person;

public class SchoolService {

	private ArrayList list = new ArrayList();
	// 매개변수로 넘어온 번호와 리스트의 내부요소의 번호와 비교하여
	// 같은 번호의 요소가 없으면 -1을 반환 / add는 -1이면 추가 / 같은 번호가 있으면 해당 인덱스를 반환
	
	public void loadData(String fileName) throws ClassNotFoundException, IOException {
		try {
			System.out.println("데이터가 로딩");
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (ArrayList)ois.readObject();
			ois.close();
		}catch(FileNotFoundException fe) {
			System.out.println("저장된 데이터 없음");
		}
	}
	
	public void saveData(String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.close();
	}
	
	public void addPerson(Person p) throws DuplicateTelException {
		int i = findIndex(p.getTel());
		if (i == -1) {
			list.add(p);
		} else {
			throw new DuplicateTelException("중복값이 존재함");
		}
	}
	
	// 클래스 내의 활용 메서드
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

	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public Person findPerson(String tel) throws PersonNotFoundException {
		Person p = null;
		int i = findIndex(tel);

		if (i == -1) {
			throw new PersonNotFoundException("찾는 구성원이 없습니다.");
		}

		p = (Person) list.get(i);
		return p;
	}

	public void deletePerson(String tel) throws PersonNotFoundException {
		int i = findIndex(tel);
		if (i == -1)
			throw new PersonNotFoundException("찾는 구성원이 없습니다.");
		list.remove(i);
	}

	public void updatePerson(String tel, Person p) throws PersonNotFoundException {
		int i = findIndex(tel);
		if (i == -1)
			throw new PersonNotFoundException("수정할 구성원이 없습니다.");
		list.set(i, p);
	}

}
