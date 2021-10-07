package service;

import java.util.ArrayList;

import vo.MemberVO;

public interface Dao {

	void con();

	void discon();

	void insert(MemberVO m);

	MemberVO selectMember(String name);

	void update(MemberVO m);

	void delete(String name);

	ArrayList printAll();

}
