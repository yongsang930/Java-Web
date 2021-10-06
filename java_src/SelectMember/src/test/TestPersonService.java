package test;

import java.util.Scanner;

import service.PersonService;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

public class TestPersonService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// ArrayList<MemberVO> list =new ArrayList<MemberVO>();
		String dept, stuId, subject;
		String name;
		String tel;
		String addr;
		boolean flag = true;
		int i = 0, y = 0;
		PersonService service = new PersonService();
		Person p = null;
		while (flag) {

			System.out.println("1.등록");
			System.out.println("2.검색");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.전체출력");
			System.out.println("6.종료");
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("이름을 입력하세요 :");
				name = sc.next();
				System.out.println("전화번호를 입력하세요 :");
				tel = sc.next();
				System.out.println("주소을 입력하세요 :");
				addr = sc.next();
				System.out.println("1.교직원");
				System.out.println("2.학생");
				System.out.println("3.교사");
				y = sc.nextInt();
				switch(y){
				case 1:
					System.out.println("부서를 입력하세요 :");
					dept = sc.next();
					p = new Employee(tel, name, addr, dept);
					break;
				case 2:
					System.out.println("학번을 입력하세요 :");
					stuId = sc.next();
					p = new Student(tel, name, addr, stuId);
					break;
				case 3:
					System.out.println("과목 입력하세요 :");
					subject = sc.next();
					p = new Teacher(tel, name, addr, subject);
					break;
				}
				
				service.addPerson(p);
				break;
			case 2:
				System.out.println("전화번호를 입력하세요 :");
				tel = sc.next();
				p = service.findPerson(tel);
				System.out.println(p);
				break;
				
			case 3:
				System.out.println("수정할 사람의 전화번호를 입력하세요 : ");
				tel = sc.next();
				System.out.println("새 이름을 입력하세요 :");
				name = sc.next();
				System.out.println("새 주소를 입력하세요 :");
				addr = sc.next();
				System.out.println("1.교직원");
				System.out.println("2.학생");
				System.out.println("3.교사");
				y = sc.nextInt();
				switch(y){
				case 1:
					System.out.println("새 부서를 입력하세요 :");
					dept = sc.next();
					p = new Employee(tel, name, addr, dept);
					break;
				case 2:
					System.out.println("새 학번을 입력하세요 :");
					stuId = sc.next();
					p = new Student(tel, name, addr, stuId);
					break;
				case 3:
					System.out.println("새 과목 입력하세요 :");
					subject = sc.next();
					p = new Teacher(tel, name, addr, subject);
					break;
				}			
				service.updatePerson(p);
			   break;
			
			case 4:
			System.out.println("삭제할 사람의 전화번호를 입력하세요 : ");
			tel = sc.next();
			service.deletePerson(tel);
			break;
			
			case 5:
				service.printAll();
		        break; 
			case 6:
				flag=false; 
			    break; 
			    
			default:
				System.out.println("잘못 입력했어요 다시 입력하세요 ");
			}

		}

	}

}
