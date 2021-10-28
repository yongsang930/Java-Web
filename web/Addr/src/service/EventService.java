package service;

import java.util.ArrayList;

import model.AddrDao;
import model.Member;

public class EventService {
	AddrDao dao;

	public EventService() {
		dao = AddrDao.getDao();
	}

	public void insert(Member m) {
		dao.insert(m);
	}

	public ArrayList<Member> list() {
		return dao.getAll();
	}

	public Member getMember(int num) {
		return dao.getMember(num);
	}

	public void edit(Member p) {
		dao.edit(p);
	}

	public void delete(int num) {
		dao.delete(num);
	}
}
