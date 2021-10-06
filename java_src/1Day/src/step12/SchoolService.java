package step12;

public class SchoolService {

	private int index;
	private Person[] p = new Person[10];

	public void addPerson(Person p) {
		this.p[index] = p;
		index++;
	}

	public void printAll() {
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}

	public Person findPerson(String tel) {
		Person per = null;
		for (int i = 0; i < index; i++) {
			if (p[i].getTel().equals(tel)) {
				per = p[i];
			}
		}
		return per;
	}
}