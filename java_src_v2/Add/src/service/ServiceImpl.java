package service;

import java.util.ArrayList;

import vo.Member;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new OracleDao();
	}

	@Override
	public boolean addMember(Member m) {
		// TODO Auto-generated method stub
		
		
		return dao.insert(m);
	}

	@Override
	public ArrayList<Member> getMember() {
		// TODO Auto-generated method stub
		return dao.print();
	}

	@Override
	public Member getMember(String name) {
		// TODO Auto-generated method stub
		return dao.select(name);
	}

	@Override
	public boolean editMember(Member m) {
		// TODO Auto-generated method stub
		return dao.update(m);
	} 

	@Override
	public boolean delMember(String name) {
		// TODO Auto-generated method stub
		return dao.delete(name);
	}

}
