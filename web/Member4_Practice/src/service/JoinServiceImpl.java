package service;

import dao.JoinDao;
import dao.JoinDaoImpl;
import model.Member;

public class JoinServiceImpl implements JoinService {

	private JoinDao dao;

	public JoinServiceImpl() {
		dao = new JoinDaoImpl();
	}

	@Override
	public boolean join(Member m) {
		return dao.insert(m);
	}

	@Override
	public Member getMember(String id, String pwd) {
		return dao.select(id, pwd);
	}

	@Override
	public void editMember(Member m) {
		dao.update(m);

	}

	@Override
	public void delMember(String id) {
		dao.delete(id);
	}
}
