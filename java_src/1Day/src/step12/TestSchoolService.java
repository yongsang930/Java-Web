package step12;

public class TestSchoolService {

	public static void main(String[] args) {

		SchoolService service = new SchoolService();

		Student s = new Student("011", "홍길동", "판교", "12");

		service.addPerson(s);

		Teacher t = new Teacher("017", "길동", "교판", "수학");
		service.addPerson(t);

		Employee e = new Employee("018", "기훈", "매탄", "영업");
		service.addPerson(e);

		service.printAll();

		Person per = service.findPerson("015");

		if (per != null)
			System.out.println(per);
		else
			System.out.println("찾는 구성원 없음!");
	}
}
