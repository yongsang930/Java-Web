package test;

import java.util.Scanner;

import service.MemberService;
import vo.MemberVO;

public class TestMemberService {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberService service = new MemberService();

		String name;
		String addr;
		String tel;
		boolean flag = true;

		while (flag) {
			System.out.println("1.등록 2.검색 3.수정 4.삭제 5.전체출력 6.종료");
			int	i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.print("아이디 입력: ");
				name = sc.next();

				System.out.print("주소 입력: ");
				addr = sc.next();
				
				System.out.print("전화번호 입력: ");
				tel = sc.next();
				
				service.addMemberVO(new MemberVO(name,tel,addr));
				
				break;
			case 2:
				System.out.print("아이디 입력: ");
				name = sc.next();
				
				MemberVO v = service.findMemberVO(name);
				System.out.println(v);
				break;
			case 3:
				System.out.print("아이디 입력: ");
				name = sc.next();

				System.out.print("수정할 주소 입력: ");
				addr = sc.next();
				
				System.out.print("수정할 전화번호 입력: ");
				tel = sc.next();
				
				MemberVO m3 = new MemberVO(name,addr,tel);
				service.updateMemberVO(m3);
				break;
			case 4:
				
				System.out.println("삭제할 아이디 입력: ");
				name = sc.next();
				service.deleteMemberVO(name);
				break;
				
			case 5:
				service.printMemberVO();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("잘못 입력");
			}

		}

	}

}
