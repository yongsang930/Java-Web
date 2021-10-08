package service;

import java.util.ArrayList;

import vo.Member;

public interface Dao {
	
	boolean insert(Member m);
	
	boolean update(Member m);
	
	boolean delete(String name);
	
	Member select(String name);
	
	ArrayList<Member> print();
	
}
