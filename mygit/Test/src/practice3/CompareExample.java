package practice3;

import java.util.Objects;

public class CompareExample {

	public static void main(String[] args) {
		Student1 s1 = new Student1(1);
		Student1 s2 = new Student1(1);
		Student1 s3 = new Student1(3);
		
		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println(result);
		result = Objects.compare(s1, s3, new StudentComparator());
		System.out.println(result);
		
	}

}
