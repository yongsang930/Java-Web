package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

public class Input {

	private String fileName = "c:\\java\\kosta\\iotest\\school.obj";

	public void startMenu() throws IOException, ClassNotFoundException, PersonNotFoundException, DuplicateTelException {

		SchoolService service = new SchoolService();
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BuffedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("학사관리 프로그램 시작");
		service.loadData(fileName);

		while (true) {
			System.out.println("| 1.추가 2.검색 3.수정 4.삭제 5.출력 6.종료 |");
			String str = br.readLine();
			if (str.equals("1")) {
				String tel, name, addr = null;
				String type = "";
				Person p = null;

				while (true) {
					System.out.println("입력할 구성원 선택 | 1.학생 2.선생 3.직원 |");
					type = br.readLine();
					if (type.equals("1") || type.equals("2") || type.equals("3")) {
						break;
					} else {
						System.out.println("잘못 입력!");
					}
				}
				System.out.println("1.전화번호: ");
				tel = br.readLine();
				System.out.println("2.이름: ");
				name = br.readLine();
				System.out.println("3.주소 ");
				addr = br.readLine();

				if (type.equals("1")) { // 추가
					System.out.println("학번 :");
					String str1 = br.readLine();
					Student stu = new Student(tel, name, addr, str1);
					p = stu; // Person 객체가 부모이기 때문에 형변환이 필요없고 다형성을 이용해 자식객체들을 p로 편하게 호출 가능

				} else if (type.equals("2")) {
					System.out.println("과목: ");
					String str2 = br.readLine();
					Teacher sub = new Teacher(tel, name, addr, str2);
					p = sub;

				} else if (type.equals("3")) {
					System.out.println("부서: ");
					String str3 = br.readLine();
					Employee emp = new Employee(tel, name, addr, str3);
					p = emp;
				} else {
					System.out.println("잘못 입력!");
				}
				try {
					service.addPerson(p);
					System.out.println(p + " 추가완료!");

				} catch (DuplicateTelException de) {
					System.out.println(de.getMessage());
				}
			} else if (str.equals("2")) { // 검색
				System.out.println("전화번호: ");
				String tel2 = br.readLine();
				try {
					System.out.println(service.findPerson(tel2));
				} catch (PersonNotFoundException pe) {
					System.out.println(pe.getMessage());
				}
			} else if (str.equals("3")) { // 수정 내가하자그냥
				System.out.println("전화번호: ");
				String tel3 = br.readLine();
				try {
					service.deletePerson(tel3);
					String tel, name, addr = null;
					String type = "";
					Person p = null;

					while (true) {
						System.out.println("수정할 구성원 선택 | 1.학생 2.선생 3.직원 |");
						type = br.readLine();
						if (type.equals("1") || type.equals("2") || type.equals("3")) {
							break;
						} else {
							System.out.println("잘못 입력!");
						}
					}
					System.out.println("1.전화번호: ");
					tel = br.readLine();
					System.out.println("2.이름: ");
					name = br.readLine();
					System.out.println("3.주소 ");
					addr = br.readLine();

					if (type.equals("1")) { // 추가
						System.out.println("학번 :");
						String str1 = br.readLine();
						Student stu = new Student(tel, name, addr, str1);
						p = stu; // Person 객체가 부모이기 때문에 형변환이 필요없고 다형성을 이용해 자식객체들을 p로 편하게 호출 가능

					} else if (type.equals("2")) {
						System.out.println("과목: ");
						String str2 = br.readLine();
						Teacher sub = new Teacher(tel, name, addr, str2);
						p = sub;

					} else if (type.equals("3")) {
						System.out.println("부서: ");
						String str3 = br.readLine();
						Employee emp = new Employee(tel, name, addr, str3);
						p = emp;
					} else {
						System.out.println("잘못 입력");
					}
					try {
						service.addPerson(p);
						System.out.println(p + " 수정완료!");

					} catch (DuplicateTelException de) {
						System.out.println(de.getMessage());
					}

				} catch (PersonNotFoundException pe) {
					System.out.println(pe.getMessage());
				}
			} else if (str.equals("4")) { // 삭제
				System.out.println("전화번호: ");
				String tel4 = br.readLine();
				try {
					service.deletePerson(tel4);
				} catch (PersonNotFoundException pe) {
					System.out.println(pe.getMessage());
				}
			} else if (str.equals("5")) { // 출력
				service.printAll();
			} else if (str.equals("6")) { // 종료
				System.out.println("학사관리 프로그램 종료!");
				service.saveData(fileName);
				break;
			} else {
				System.out.println("잘못 입력!");
			}

		}
	}
}
