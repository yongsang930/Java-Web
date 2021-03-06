package order.service;

import java.util.ArrayList;

import model.Order;
import order.dao.Dao;
import order.dao.DaoImpl;

public class ServiceImpl implements Service {
	private Dao dao;
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public void addOrder(Order o) {
		// TODO Auto-generated method stub
		dao.insert(o);
	}

	@Override
	public Order getOrder(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public ArrayList<Order> orderList(String o_id, int o_state) {
		// TODO Auto-generated method stub
		return dao.selectAll(o_id, o_state);
	}

	@Override
	public void editState(String type, int num) {
		// TODO Auto-generated method stub
		dao.update(type, num);
	}

	@Override
	public void delOrder(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}
	@Override
	public ArrayList<Integer> orderPNum(String o_id) {
		return dao.selectPNum(o_id);
	}
	@Override
	public ArrayList<Order> sellerPrAll(String s_id) {
		return dao.sellerAll(s_id);
	}
	@Override
	public ArrayList<Order> selectOList(String o_id) {
		return dao.selectOList(o_id);
	}

}
