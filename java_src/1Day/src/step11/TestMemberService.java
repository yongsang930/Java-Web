package step11;

public class TestMemberService {

	public static void main(String[] args) {
		
		Dao service = new DaoImpl();
		
		service.connect();
		service.addPerson(new MemberVO(1,"손연재", "부서","주소"));
		service.addPerson(new MemberVO(2,"김연아", "컴퓨터","군포"));
		service.addPerson(new MemberVO(3,"홍명보", "전산","파주"));
		
		service.printAll();
		
		MemberVO vo = service.findPerson("손연재");
		
		if(vo!=null)
			System.out.println(vo);
		else 
			System.out.println("회원이 아닙니다.");
		
		
		Dao service2 = new DaoImpl2();
		
		service2.connect();
		service2.addPerson(new MemberVO(1,"손연재", "부서","주소"));
		service2.addPerson(new MemberVO(2,"김연아", "컴퓨터","군포"));
		service2.addPerson(new MemberVO(3,"홍명보", "전산","파주"));
		
		service2.printAll();
		
		MemberVO vo2 = service2.findPerson("손연재");
		
		if(vo!=null)
			System.out.println(vo2);
		else 
			System.out.println("회원이 아닙니다.");
	}
}
