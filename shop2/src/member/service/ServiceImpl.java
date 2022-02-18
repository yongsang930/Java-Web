package member.service;

import member.dao.Dao;
import member.dao.DaoImpl;
import model.Member;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		this.dao = new DaoImpl();
	}

	public void join(Member m) {
		dao.insert(m);
	}

	public Member getMember(String id, String pwd) {

		return dao.select(id, pwd);
	}

	public void editMember(Member m) {
		dao.update(m);
	}

	public void remMember(String id) {
		dao.delete(id);
	}
	
	public 	boolean check(String id) {
		return dao.check(id);
	}
	
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		Member m = dao.select(id, pwd);
		if (m == null || !m.getPwd().equals(pwd)) {
			return false;
		} else {
			return true;
		}
	}
}
