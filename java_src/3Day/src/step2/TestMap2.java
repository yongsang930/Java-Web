package step2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TestMap2 {

	public static void main(String[] args) {

		HashMap map = new HashMap();

		map.put("a", new FriendVO("아이유", "오산", 161));
		map.put("b", new FriendVO("김예솔", "매탄", 153));
		map.put("c", new FriendVO("김소현", "수원", 162));

		System.out.println(map);

		FriendVO vo = (FriendVO) map.get("c");
		System.out.println(vo.getName() + " " + vo.getAddr() + " " + vo.getMoney());

		System.out.println(map.get("c"));

		Set set = map.keySet();
		System.out.println(set);

		Iterator it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("****map의 value들만 출력****");
		Collection col = map.values();
		Iterator it2 = col.iterator();

		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
}
