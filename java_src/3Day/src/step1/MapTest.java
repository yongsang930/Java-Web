package step1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "박용상");
		map.put("tel", "김예솔");
		map.put("addr", "이상백");
		
		System.out.println("값을 확인하고 싶은 key를 입력하라: ");
		
		String key = "";  
		key = sc.next();
		
		if(map.containsKey(key)) {
			System.out.println("key " + key + "의 값: " + map.get(key));
		}else {
			System.out.println("일치하는 key가 없다.");
		}
		
		System.out.println("map의 전체 key 출력");
		Object[] keys = map.keySet().toArray();	
		
		for (int i = 0; i < key.length(); i++) {
			System.out.println((String)keys[i]);
		}
		
		System.out.println("map의 전체 values 출력");
		Object[] values = map.values().toArray();	
		for (int i = 0; i < values.length; i++) {
			System.out.println((String)values[i]);
		}
		
		System.out.println("map의 전체 values 출력");
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i] + ": " + map.get((String)values[i]));
		}
		
		sc.close();
	}
}
