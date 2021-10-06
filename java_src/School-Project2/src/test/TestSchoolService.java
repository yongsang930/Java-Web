package test;

import service.SchoolService;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

public class TestSchoolService {
	public static void main(String[] args) {
		
		SchoolService service = new SchoolService();
		
		Student s = new Student("011","커리어","판교","12");
		service.addPerson(s);
		
		Teacher t = new Teacher("017","황정민","익산","구거");
		service.addPerson(t);
		
		Employee e = new Employee("015", "성태", "수지", "전산");
		service.addPerson(e);
		
		service.printAll();
		
		Person per = service.findPerson("017");
		
		if(per != null) 
			System.out.println(per);
		else 
			System.out.println("없습니다.");
		
		service.deletePerson("017");
		service.printAll();
	}
}
