package service;

import model.Member;

public interface JoinService {

	boolean join(Member m);

	Member getMember(String id, String pwd);

	void editMember(Member m);

	void delMember(String id);
}
