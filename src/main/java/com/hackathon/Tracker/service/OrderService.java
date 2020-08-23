package com.hackathon.Tracker.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hackathon.Tracker.dto.OrderDTO;

public interface OrderService {
	public List<OrderDTO>getAllOrders();
	public OrderDTO getOrderById(int orderId);
	public List<OrderDTO> getByStatus(String status);
	public OrderDTO getNewOrder(OrderDTO s );
	public OrderDTO updateOrder(int orderId,OrderDTO o);
	public OrderDTO deleteOrder(@PathVariable(name="id")int orderId);

}
