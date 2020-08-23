package com.hackathon.Tracker.dao;

import java.util.List;

import com.hackathon.Tracker.Entity.Order;
import com.hackathon.Tracker.dto.OrderDTO;

public interface OrderDAO {
	
	public List<Order> getAllOrders();
	public Order getOderByID(int orderId);
	public List<Order> getOrderByStatus(String status);
	public Order getNewOrder(Order s);
	public Order deleteOrder(Order o);

}
