package Practice6_3;

import Practice6_1.Student;

// 6_1과 연결된 문제
public class Exercise6_3 {

	public static void main(String[] args) {
		Student s = new Student();
		
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름: " + s.name);
		System.out.println("총점: " + s.getTotal());
		System.out.println("총점: " + s.getAverage());
	}
}
