package step1;

import java.util.HashMap;

public class TestMap1 {

	public static void main(String[] args) {
		HashMap map = new HashMap();

		map.put("iu", "아이유");
		map.put("boa", "보아");
		
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get("boa"));
		
		map.put("iu", "현아");
		
		System.out.println(map);
		
		boolean flag = map.containsKey("iu");
		System.out.println(flag);
		
		map.remove("iu");
		System.out.println(map);
		
		
		map.put("nayeon", "나연");
		map.put("sana", "사나");
		
		System.out.println(map.isEmpty( ));
		System.out.println(map);
		
		map.clear();
		System.out.println(map);
		
		System.out.println(map.isEmpty( ));
		System.out.println(map);
	}
}
