package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

public class Input {

	public void showMenu() throws IOException, DuplicateTelException, PersonNotFoundException {

		SchoolService service = new SchoolService();
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);

		System.out.println("****학사관리프로그램 실행한다~****");

		while (true) {
			System.out.println("| 1.추가 | 2.삭제 | 3.검색 | 4.전체회원 | 5.종료 |");
			String str = br.readLine();
			if (str.equals("1")) {
				String tel = null, name = null, addr = null;
				String type = "";
				Person p = null;

				while (true) {
					System.out.println("입력할 구성원의 종류를 선택해");
					System.out.println("| 1.학생 | 2.선생 | 3.직원 |");
					type = br.readLine();
					if (type.equals("1") || type.equals("2") || type.equals("3")) {
						break;
					} else {
						System.out.println("잘못 입력");
					}
				}
				System.out.println("1.전화번호: ");
				tel = br.readLine();
				System.out.println("2.이름: ");
				name = br.readLine();
				System.out.println("3.주소: ");
				addr = br.readLine();
				if (type.equals("1")) {
					System.out.println("4.학번: ");
					String str4 = br.readLine();
					Student stu = new Student(tel, name, addr, str4);
					p = stu;

				} else if (type.equals("2")) {
					System.out.println("4.과목: ");
					String str4 = br.readLine();
					Teacher stu = new Teacher(tel, name, addr, str4);
					p = stu;
				} else if (type.equals("3")) {
					System.out.println("4.부모: ");
					String str4 = br.readLine();
					Employee stu = new Employee(tel, name, addr, str4);
					p = stu;
				} else {
					System.out.println("잘못 입력");
				}
				try {
					service.addPerson(p);
					System.out.println(p + " add ok");
				} catch (DuplicateTelException de) {
					System.out.println(de.getMessage());
				}
			} else if (str.equals("2")) {

				System.out.println("1.전화번호: ");
				String tel2 = br.readLine();
				try {
					service.deletePerson(tel2);
				} catch (PersonNotFoundException pe) {
					System.out.println(pe.getMessage());
				}

			} else if (str.equals("3")) {
				System.out.println("1.전화번호: ");
				String tel1 = br.readLine();
				try {
					System.out.println(service.findPerson(tel1));
				} catch (PersonNotFoundException pe) {
					System.out.println(pe.getMessage());
				}
			} else if (str.equals("4")) {
				service.printAll();
			} 
			else if (str.equals("5")) {
				System.out.println("학사관리 프로그램 종료");
				break;
			} else {
				System.out.println("잘못 입력");
			}
		}
	}
}
