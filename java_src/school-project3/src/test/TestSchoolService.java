package test;

import service.SchoolService;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

public class TestSchoolService {
	public static void main(String[] args) {

		SchoolService service = new SchoolService();
		Student s2 = new Student();
		Student s = new Student("011", "크리스탈", "판교", "12");
		service.addPerson(s);

		Teacher t = new Teacher("012", "설리", "남산", "국어");
		service.addPerson(t);

		Employee e = new Employee("018", "박우희", "법성포", "백수");
		service.addPerson(e);
		
		service.printAll();
		
		Person per = service.findPerson("018");
		if(per != null) 
			System.out.println(per);
		else 
			System.out.println("찾는 사람이 없음");
		
		service.deletePerson("011");
		service.printAll();
		
		service.updatePerson("019", new Student("010","밈은영","보성","65"));
		service.printAll();
	}
}
