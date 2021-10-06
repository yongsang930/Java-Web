package step2;

import step1.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectInput {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("c:\\java-kosta\\iotest\\person.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person person = (Person)ois.readObject();
			System.out.println("역직렬화-"+person);
			ois.close();
			
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
	}
}
