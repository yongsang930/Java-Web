import java.util.NavigableSet;
import java.util.TreeSet;

public class HashTableExample {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");

		System.out.println("[c = f 사이의 단어 검색]");
		NavigableSet<String> rangSet = treeSet.subSet("c",true,"f",true);
		for(String word : rangSet) {
			System.out.println(word);
		}
	}

}
