package practice3;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student1> {
	
	@Override
	public int compare(Student1 a, Student1 b) {
		if(a.sno < b.sno)
			return -1;
		else if ( a.sno == b.sno)
			return 0;
		else 
			return 1;
	}
}
