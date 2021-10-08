package test;

import java.util.ArrayList;
import java.util.Scanner;

import service.MemberService;
import service.Service;
import vo.Employee;
import vo.Professor;
import vo.Student;
import vo.member;

public class TestMemberService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ArrayList list = new ArrayList();

		boolean flag = true;

		String id = null;
		String name = null;
		String tel = null;
		String addr = null;
		String etc = null;
		int type = 0;

		member m = null;

		String[] tag = { "", "school", "dept", "job" };

		Service service = new MemberService();

		while (flag) {
			System.out.println("1.등록");
			System.out.println("2.검색");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.전체출력");
			System.out.println("6.종료");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("그룹선택\n1.학생 2.교수 3.교직원");
				type = sc.nextInt();
				System.out.print("아이디 입력: ");
				id = sc.next();
				System.out.print("이름 입력: ");
				name = sc.next();
				System.out.print("전화번호 입력: ");
				tel = sc.next();
				System.out.print("주소 입력: ");
				addr = sc.next();

				System.out.print(tag[type] + "을 입력: ");
				etc = sc.next();

				if (type == 1)
					service.addMember(new Student(id, name, tel, addr, type, etc));
				else if (type == 2)
					service.addMember(new Professor(id, name, tel, addr, type, etc));
				else if (type == 3)
					service.addMember(new Employee(id, name, tel, addr, type, etc));
				else
					System.out.println("일치하는 것이 없음");
				break;
			case 2:
				System.out.print("아이디 입력: ");
				id = sc.next();
				System.out.println(service.getMember(id));
				break;

			case 3:

				System.out.print("수정할 아이디 조회: ");
				id = sc.next();

				if (service.getMember(id) == null) {
					break;
				}
				System.out.println("그룹선택\n1.학생 2.교수 3.교직원");
				type = sc.nextInt();
				if (type < 0 || type > 3) {
					System.out.println("번호 입력오류");
					break;
				}
				System.out.print("이름 입력: ");
				name = sc.next();
				System.out.print("전화번호 입력: ");
				tel = sc.next();
				System.out.print("주소 입력: ");
				addr = sc.next();
				System.out.print(tag[type] + "을 입력: ");
				etc = sc.next();

				m = service.getMember(id);

				if (m.getType() == 1)
					service.editMember(new Student(id, name, tel, addr, type, etc));
				else if (m.getType() == 2)
					service.editMember(new Professor(id, name, tel, addr, type, etc));
				else if (m.getType() == 3)
					service.editMember(new Employee(id, name, tel, addr, type, etc));
				break;

			case 4:
				System.out.print("삭제할 아이디: ");
				id = sc.next();

				if (service.getMember(id) != null)
					service.delMember(id);
				break;
			case 5:
				System.out.println("출력할 그룹선택\n1.학생 2.교수 3.교직원");
				type = sc.nextInt();
				if (type < 0 || type > 3) {
					System.out.println("번호 입력오류");
					break;
				}
				System.out.println(service.getMembers(type));
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("입력 오류! 재입력하세요.");
			}

		}

	}

}
