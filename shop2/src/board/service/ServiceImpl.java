package board.service;

import java.util.ArrayList;
import java.util.List;

import board.dao.Dao;
import board.dao.DaoImpl;
import model.Board;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void writeBoard(Board b) {
		dao.insert(b);

	}

	@Override
	public Board getBoard(int num) {
		return dao.select(num);
	}

	@Override
	public ArrayList<Board> getAll() {
		return dao.selectAll();
	}

	@Override
	public void editBoard(Board b) {
		dao.update(b);
	}

	@Override
	public void delBoard(int num) {
		dao.delete(num);
	}

}
