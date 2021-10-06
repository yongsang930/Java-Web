package step2;

import java.util.ArrayList;

public class TestList2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(new FriendVO("아이유",11));
		list.add(new FriendVO("사나",22));
		list.add(new FriendVO("나연",33));
		list.add(new FriendVO("미나",44));
		list.add(new FriendVO("채영",55));
		list.add(new FriendVO("채영",56));
		list.add(new FriendVO("채영",57));
		list.add(new FriendVO("채영",85));
		list.add(new FriendVO("채영",585));
		
//		System.out.println(list.size());
//		System.out.println(list);
		
		//FriendVO에 toString()을 오버라이딩 해준다.
		//0번 인덱스의 이름만 출력
		      //list.get()은 Object형으로 반환하므로
		      //FriendVO의 getName()을 호출하기 위해서는 Object casting이 필요
		      //Object o1 = list.get(0);
		FriendVO vo2 = (FriendVO)list.get(8);
		
		System.out.println(vo2.getAge());
		
		System.out.println("****list안의 모든 요소 출력");
		for (int i = 0; i < list.size(); i++) {
			FriendVO vo3 = (FriendVO) list.get(i);
			System.out.println(vo3.getName());
		}
		
		System.out.println("****list안의 요소중 25세 이상인 이름만 출력");
		for (int i = 0; i < list.size(); i++) {
			FriendVO vo3 = (FriendVO) list.get(i);
			if(vo3.getAge() >= 25)
			System.out.println(vo3.getName());
		}
		
		
	}
}
