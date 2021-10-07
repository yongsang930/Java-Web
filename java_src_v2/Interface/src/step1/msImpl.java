package step1;

public class msImpl implements DbInterface {

	@Override
	public void connect() {
		System.out.println("ms-sql 데이터 베이스 시스템에 연결합니다.");
	}

	@Override
	public void select() {
		
		System.out.println("ms-sql 데이터 베이스 시스템에 조회합니다.");
	}

	@Override
	public void insert() {
		
		System.out.println("ms-sql 데이터 베이스 시스템에 추가합니다.");
	}

	@Override
	public void delete() {
		System.out.println("ms-sql 데이터 베이스 시스템에 삭제합니다.");
		
	}
}
