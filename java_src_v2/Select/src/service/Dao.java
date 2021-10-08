package service;

import java.util.ArrayList;

import vo.member;

public interface Dao {
	void con();
	void discon();
	void insert(member m);
	member selectMember(String id);
	void update(member m);
	void delete(String id);
	ArrayList selectAll(int type);
}
