package test;

import java.io.IOException;

import exception.DuplicateTelException;
import exception.PersonNotFoundException;
import service.Input;
import service.SchoolService;

public class TestSchoolService {

	public static void main(String[] args) {
		Input input = new Input();

		try {
			input.showMenu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DuplicateTelException de) {
			de.printStackTrace();
		} catch (PersonNotFoundException pe) {
			pe.printStackTrace();
		}
	}
}
