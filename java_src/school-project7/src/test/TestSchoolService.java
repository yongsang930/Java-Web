package test;

import java.io.IOException;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import service.Input;

public class TestSchoolService {
	public static void main(String[] args) {
		
		Input input = new Input();
		
		try {
			input.startMenu();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(DuplicateTelException de) {
			de.printStackTrace();
		}catch(PersonNotFoundException pe) {
			pe.printStackTrace();
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
}
