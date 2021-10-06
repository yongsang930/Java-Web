package Practice_9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class main {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(10);
		
		list1.add(1);
		list1.add(7);
		list1.add(8);
		list1.add(2);
		list1.add(5);
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		
		System.out.println(list1 +" " +list2);
		
		Collections.sort(list1);
		Collections.sort(list2);
		System.out.println(list1 +" " +list2);
		
		System.out.println(list1.containsAll(list2));
		
		list2.add("b");
		list2.add("c");
		list2.add(2,"b");
		System.out.println(list1 +" " +list2);

		list2.set(3, "aa");
		System.out.println(list1 +" " +list2);

		list1.add(0,"9");
		System.out.println(list1 +" " +list2);
		System.out.println(list1.indexOf(8));
		
		
		list1.remove(3);
		System.out.println(list1 +" " +list2);
		
		
		
		
	}
}
