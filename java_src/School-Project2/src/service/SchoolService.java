package service;

import java.util.ArrayList;

import vo.Person;

public class SchoolService {

	private ArrayList<Person> list = new ArrayList<Person>();

	/**
	 * 학교 구성원을 추가하는 메서드 --> 보강 : 동일한 전화번호가 있으면 추가 시키지 않는다
	 */

	public void addPerson(Person p) {
		boolean flag=false;
		for (int i = 0; i < list.size(); i++) {
			Person per=list.get(i);
			if(p.getTel().equals(per.getTel())){
				flag=true;//동일한 전화번호가 존재!!
			}
		}
		if(flag==false){
			list.add(p);//동일한 전화번호가 없을 때 추가
		}else{
			System.out.println("동일한 번호 존재하여 추가불가!");
		}
	}

	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			System.out.println(p);
			System.out.println("*********");
		}
	}

	public Person findPerson(String tel) {
		Person per = null;
		for (int i = 0; i < list.size(); i++) {
			// list에 있는 개별요소 객체를 Person type으로 casting
			// 개별 요소 객체 전화번호를 얻기 위해
			Person p = list.get(i);
			if (p.getTel().startsWith(tel)) {
				per = p;
				break;// 한명 찾았으므로 더 돌 필요가 없다.
				// 찾았으면 해당 for문을 벗어난다.
			}
		}
		return per;

	}

	public void deletePerson(String tel) {
		for (int i = 0; i < list.size(); i++) {
			Person p =  list.get(i);
			if (p.getTel().startsWith(tel)) {
				list.remove(i);
				break;
			}
		}

	}

	public void updatePerson(String tel, Person p) {
		// 업데이트가 멀로 될지 모르므로 Person 으로 정의
		for (int i = 0; i < list.size(); i++) {
			Person per = list.get(i);
			if (per.getTel().startsWith(tel)) {
				list.set(i, p);
				break;
			} 
		}
	}

}
