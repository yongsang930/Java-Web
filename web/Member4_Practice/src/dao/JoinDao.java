package dao;

import model.Member;

public interface JoinDao {

	boolean insert(Member m);

	Member select(String id, String pwd);

	void update(Member m);

	void delete(String id);

}
