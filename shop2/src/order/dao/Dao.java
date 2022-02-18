package order.dao;

import java.util.ArrayList;

import model.Order;

public interface Dao {
	void insert(Order o);
	Order select(int num);
	ArrayList<Order> selectAll(String o_id, int o_state);
	ArrayList<Integer> selectPNum(String o_id);
	void delete(int num);
	void update(String type, int num);
	ArrayList<Order> sellerAll(String s_id);
	ArrayList<Order> selectOList(String o_id);
}
