package step1;

public class Main {

	public static void main(String[] args) {
		
		Process p1 = new Process(new OracleImpl());
		p1.connect();
		p1.select();
		p1.delete();
		p1.insert();

		Process p2 = new Process(new msImpl());
		p2.connect();
		p2.select();
		p2.delete();
		p2.insert();
	}
}