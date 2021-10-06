package practice3;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Method call = new Method(scan.nextInt(), scan.nextInt());
		
		scan.close();
		
		call.methodOne();
		
		System.out.println(call.num1 + " " + call.num2);
	}
}

class Method {
	int num1;
	int num2;
	
	Method(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	void methodOne(){
		if(num1 > num2) {
			num1 = num1 / 2;
			num2 = num2 * 2;
		} else {
			num2 = num2 / 2;
			num1 = num1 * 2;
		}
	}
}
