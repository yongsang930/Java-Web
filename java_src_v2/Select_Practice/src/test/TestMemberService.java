package test;

import java.util.Scanner;

import service.MemberService;
import service.Service;
import vo.Employee;
import vo.Member;
import vo.Professor;
import vo.Student;

public class TestMemberService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Service service = new MemberService();

		int type = 0;
		String id = null;
		String name = null;
		String tel = null;
		String addr = null;
		String etc = null;

		Member m = null;

		boolean flag = true;

		String[] exe = { "school", "dept", "job" };

		while (flag) {
			System.out.println("1.등록 2.검색 3.수정 4.삭제 5.출력 6.종료");
			int i = sc.nextInt();

			switch (i) {
			case 1:
				System.out.println("1.학생 2.선생 3.교직원");
				type = sc.nextInt();
				if (type < 1 || type > 3) {
					System.out.println("입력 오류");
					break;
				}
				System.out.print("아이디 입력: ");
				id = sc.next();
				System.out.print("이름 입력: ");
				name = sc.next();
				System.out.print("전화번호 입력: ");
				tel = sc.next();
				System.out.print("주소 입력: ");
				addr = sc.next();
				System.out.print(exe[type - 1] + " 입력: ");
				etc = sc.next();

				if (type == 1)
					service.addMember(new Student(id, name, tel, addr, type, etc));
				else if (type == 2)
					service.addMember(new Professor(id, name, tel, addr, type, etc));
				else if (type == 3)
					service.addMember(new Employee(id, name, tel, addr, type, etc));
				break;
			case 2:
				System.out.print("아이디 입력: ");
				id = sc.next();
				System.out.println(service.getMember(id));
				break;
			case 3:
				System.out.print("아이디 입력: ");
				id = sc.next();
				m = service.getMember(id);

				if (m != null) {
					System.out.println("\n타입을 새로 선택 1.학생 2.선생 3.교직원");
					type = sc.nextInt();
					if (type < 1 || type > 3) {
						System.out.println("입력 오류");
						break;
					}
					System.out.print("새로운 이름 입력: ");
					name = sc.next();
					System.out.print("새로운 전화번호 입력: ");
					tel = sc.next();
					System.out.print("새로운 주소 입력: ");
					addr = sc.next();
					System.out.print("새로운 " + exe[type - 1] + " 입력: ");
					etc = sc.next();

					if (m.getType() == 1)
						service.editMember(new Student(id, name, tel, addr, type, etc));
					else if (m.getType() == 2)
						service.editMember(new Professor(id, name, tel, addr, type, etc));
					else if (m.getType() == 3)
						service.editMember(new Employee(id, name, tel, addr, type, etc));
				}
				break;
			case 4:
				System.out.print("아이디 입력: ");
				id = sc.next();
				m = service.getMember(id);
				if (m != null)
					service.delMember(id);
				else
					System.out.println(m);
				break;
			case 5:
				System.out.println("출력할 타입을 선택 1.학생 2.선생 3.교직원");
				type = sc.nextInt();
				
				if (type < 1 || type > 3) 
					System.out.println("입력 오류");
					
				System.out.println(service.getMember(type));
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("입력 오류");
				break;
			}
		}
	}
}
