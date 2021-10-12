package test;

import java.util.Scanner;

import board.Board;
import join.Member;

public class Main {

	public static String loginId = "";

	public static void func1(Scanner sc, join.Service service) {

		int menu = 0;
		String id = "", pwd = "";
		boolean flag = true, loginFlag = false;
		Member m = null;

		while (flag) {
			System.out.println("1.회원가입 2.내정보수정 3.로그인 4.로그아웃 5.탈퇴 6.종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				m = new Member();
				System.out.print("id:");
				m.setId(sc.next());
				System.out.print("pwd:");
				m.setPwd(sc.next());
				System.out.print("name:");
				m.setName(sc.next());
				System.out.print("email:");
				m.setEmail(sc.next());
				service.addMember(m);
				break;

			case 2:
				if (loginId.equals("") || loginId == null) {
					System.out.println("로그인 먼저 하시오");
				} else {
					m = new Member();
					m.setId(loginId);
					System.out.print("new pwd:");
					m.setPwd(sc.next());
					System.out.print("new email:");
					m.setEmail(sc.next());
					service.editMemberInfo(m);
				}
				break;
			case 3:
				System.out.print("id:");
				id = sc.next();
				System.out.print("pwd:");
				pwd = sc.next();

				loginFlag = service.login(id, pwd);

				if (loginFlag) {
					loginId = id;
					System.out.println(id + "님 로그인 성공");
				} else
					System.out.println("로그인 실패");
				break;
			case 4:
				if (loginId.equals("") || loginId == null) {
					System.out.println("로그인 먼저 하시오");
				} else {
					loginId = "";
				}
				break;
			case 5:
				if (loginId.equals("") || loginId == null) {
					System.out.println("로그인 먼저 하시오");
				} else {
					service.removeMember(loginId);
				}
				break;
			case 6:
				flag = false;
			}
		}

	}

	public static void func2(Scanner sc, board.Service service) {
		int menu = 0, num = 0;
		boolean flag = true;
		Board b = null;

		while (flag) {
			System.out.println("1.글쓰기 2.글 번호로 검색 3.글수정 4.글삭제 5.전체글보기 6.종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				if (loginId.equals("") || loginId == null) {
					System.out.println("로그인 먼저 하시오");
				} else {
					b = new Board();
					b.setWriter(loginId);
					System.out.print("글 비밀번호:");
					b.setPwd(sc.next());
					System.out.print("제목:");
					sc.nextLine();
					b.setTitle(sc.nextLine());
					System.out.print("내용:");
					b.setContent(sc.nextLine());
					service.write(b);
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				flag = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		join.Service joinService = new join.ServiceImpl();
		board.Service boardService = new board.ServiceImpl();
		int menu = 0;
		boolean flag = true;
		while (flag) {
			System.out.println("1.회원관리 2.게시판 3. 창고 4. 종료 ");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				func1(sc, joinService);

				break;
			case 2:
				func2(sc, boardService);
				break;
			case 3:
				break;
			case 4:
				flag = false;
				break;
			}
		}
	}
}