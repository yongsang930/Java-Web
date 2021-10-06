import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String name = scan.next();
		String School = scan.next();
		int grade = scan.nextInt();
		
		scan.close();
		
		test st = new test();
		st.setName(name);
		st.setSchool(School);
		st.setGrade(grade);
		st.print();
	}
}

class test {
	private String name;
	private String School;
	private int Grade;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSchool(String school) {
		School = school;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public void print() {
		System.out.println("Name : " + name);
		System.out.println("School : " + School);
		System.out.println("Grade : " + Grade);
	}
}
