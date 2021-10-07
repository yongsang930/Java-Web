package service;

import oracle.net.aso.p;
import vo.MemberVO;

public class MemberService {

	private Dao dao;

	public MemberService() {
		dao = new MemberDao();
	}

	public void addMemberVO(MemberVO memberVO) {
		dao.insert(memberVO);
	}

	public MemberVO findMemberVO(String name) {
		return dao.selectMember(name);
	}

	public void updateMemberVO(MemberVO memberVO) {
		dao.update(memberVO);
	}

	public void deleteMemberVO(String name) {
		dao.delete(name);
	}

	public void printMemberVO() {
		dao.printAll();
	}
}
