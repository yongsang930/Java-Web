package step1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectOutput {
	public static void main(String[] args) {

		Person person = new Person("박용상", "백수새끼", "경기도 오산");
		
		try {
			FileOutputStream fos = new FileOutputStream("c:\\java-kosta\\iotest\\person.obj"); // 파일을 저장
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
			System.out.println("객체를 직렬화하여 저장");
			oos.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
