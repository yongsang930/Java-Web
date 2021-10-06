package test;

import service.SchoolService;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;
import exception.DuplicateTelException;
import exception.PersonNotFoundException;

public class TestSchoolService {
	/**
	 * try catch
	 */
	public static void main(String[] args) {
		SchoolService service = new SchoolService();
		/*
		 * try{ service.addPerson(new Student("011","아이유","종로","12"));
		 * System.out.println("add ok!"); }catch(DuplicaeTelException de){
		 * System.out.println(de.getMessage()); } try{ service.addPerson(new
		 * Student("011","아이유","종로","12")); System.out.println("add ok!");
		 * }catch(DuplicaeTelException de){ System.out.println(de.getMessage());
		 * }
		 */
		try {
			service.addPerson(new Student("011", "아이유", "종로", "12"));
			System.out.println("add ok!");
		} catch (DuplicateTelException de) {
			System.out.println(de.getMessage());

		}

		try {
			service.addPerson(new Employee("011", "아이유", "종로", "12"));
			System.out.println("add ok!");
		} catch (DuplicateTelException de) {
			System.out.println(de.getMessage());

		}

		try {
			service.addPerson(new Employee("012", "아아아", "성남", "부서"));
			System.out.println("add ok!");
		} catch (DuplicateTelException de) {
			System.out.println(de.getMessage());

		}
		try {
			service.addPerson(new Teacher("013", "이이이", "부산", "과목"));
			System.out.println("add ok!");
		} catch (DuplicateTelException de) {
			System.out.println(de.getMessage());

		}
		service.printAll();
		System.out.println("*********************");
		try {
			Person p = service.findPerson("013");
			System.out.println("find:" + p);
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*********************");
		try {
			service.deletePerson("013");
			System.out.println("삭제ok!");
			service.printAll();
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("**********************");
		try {
			service.updatePerson("012", new Student("019", "백박사", "상대원", "06"));
			service.printAll();
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
