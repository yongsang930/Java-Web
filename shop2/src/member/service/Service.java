package member.service;

import model.Member;

public interface Service {
	void join(Member m);
	Member getMember(String id, String pwd);
	void editMember(Member m);
	void remMember(String id);
	boolean login(String id, String pwd);
	boolean check(String id);
}
