package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.security.SecurityPermission;

import service.BoardService;
import vo.Member;

public class TestBoardService {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String fileName = "school.obj";

		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(ir);
		System.out.println("-----간단한 게시판을 시작한다-----");

		String id;
		String contents;

		boolean flag = true;
		String i = "";
		BoardService service = new BoardService();
//		service.loadData(fileName);                  // 자료가 없으면 여기서 에러남 자료 없을때는 주석처리하고 나중에 풀것 

		while (flag) {
			System.out.println("1.글입력 2.검색 3.수정 4.삭제 5.내용보기 6.종료");
			i = br.readLine();

			switch (i) {
			case "1":
				System.out.println("아이디 입력: ");
				id = br.readLine();
				System.out.println("내용 입력: ");
				contents = br.readLine();
				service.insertBoard(new Member(id, contents));
				service.savaData(fileName);
				break;
				
			case "2":
				System.out.println("검색할 아이디: ");
				id = br.readLine();
				Member m2 = service.findBoard(id);
				if(m2==null)
					System.out.println("검색결과가 없습니다");
				else
					System.out.println(m2);
				break;
				
			case "3":
				System.out.println("수정할 아이디: ");
				id = br.readLine();
				
				System.out.println("수정할 내용: ");
				contents = br.readLine();
				
				Member m3 = new Member(id, contents);
				service.updateBoard(m3);
				break;
				
			case "4":
				System.out.println("삭제할 아이디: ");
				id = br.readLine();
				service.deleteBoard(id);
				break;
			case "5":
				service.printBoard();
				break;
			case "6":
				flag = false;
				break;
			}
		}
	}
}
