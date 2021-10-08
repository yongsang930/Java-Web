package service;

import java.util.ArrayList;

import vo.Member;

public interface Service {
	
	boolean addMember(Member M);

	ArrayList<Member> getMember();

	Member getMember(String name);

	boolean editMember(Member m);

	boolean delMember(String name);

}
