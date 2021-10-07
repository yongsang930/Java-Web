package step1;

public class Process {

	private DbInterface db;
	
	public Process(DbInterface db) {
		this.db = db;
	}
	void connect() {
		db.connect();
	}
	
	void select() {
		db.select();
	}
	
	void insert() {
		db.insert();
	};
	
	void delete() {
		db.delete();
	};
	
}
