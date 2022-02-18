package order.service;

import java.util.ArrayList;

import model.Order;

public interface Service {
	void addOrder(Order o);
	Order getOrder(int num);
	ArrayList<Order> orderList(String o_id, int o_state);
	ArrayList<Integer> orderPNum(String id);
	void editState(String type, int num);
	void delOrder(int num);
	ArrayList<Order> sellerPrAll(String s_id);
	ArrayList<Order> selectOList(String o_id);
}
