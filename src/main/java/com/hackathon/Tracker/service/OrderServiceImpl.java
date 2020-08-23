package com.hackathon.Tracker.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.Tracker.Entity.Order;
import com.hackathon.Tracker.dao.OrderDAO;
import com.hackathon.Tracker.dto.OrderDTO;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO dao;
	

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<OrderDTO>l=new ArrayList<OrderDTO>();
		for(Order o:dao.getAllOrders()) {
			OrderDTO dto=new OrderDTO();
			dto.setOrderId(o.getOrderId());
			dto.setBuyerId(o.getBuyerId());
			dto.setBuyerName(o.getBuyerName());
			dto.setAmount(o.getAmount());
			dto.setOrderDate(o.getOrderDate());
			dto.setExpectedTime(o.getExpectedTime());
			dto.setDeliveryArea(o.getDeliveryArea());
			dto.setStatus(o.getStatus());
			l.add(dto);
			
			}
		return l;
	}

	@Override
	public OrderDTO getOrderById(int orderId) {
		OrderDTO dto=new OrderDTO();
		Order o=dao.getOderByID(orderId);
		dto.setOrderId(o.getOrderId());
		dto.setBuyerId(o.getBuyerId());
		dto.setBuyerName(o.getBuyerName());
		dto.setAmount(o.getAmount());
		dto.setOrderDate(o.getOrderDate());
		dto.setExpectedTime(o.getExpectedTime());
		dto.setDeliveryArea(o.getDeliveryArea());
		dto.setStatus(o.getStatus());
		return dto;
		
		
	}

	@Override
	public List<OrderDTO> getByStatus(String status)
	{
		List<OrderDTO>l=new ArrayList<OrderDTO>();
		for(Order o:dao.getOrderByStatus(status))
		{
		OrderDTO dto=new OrderDTO();
		dto.setOrderId(o.getOrderId());
		dto.setBuyerId(o.getBuyerId());
		dto.setBuyerName(o.getBuyerName());
		dto.setAmount(o.getAmount());
		dto.setOrderDate(o.getOrderDate());
		dto.setExpectedTime(o.getExpectedTime());
		dto.setDeliveryArea(o.getDeliveryArea());
		dto.setStatus(o.getStatus());
		l.add(dto);
		}
		return l;
		
		}

	@Override
	public OrderDTO getNewOrder(OrderDTO s) {
		Order o=new Order();
		o.setOrderId(s.getOrderId());
		o.setBuyerId(s.getBuyerId());
		o.setBuyerName(s.getBuyerName());
		o.setAmount(s.getAmount());
		o.setOrderDate(s.getOrderDate());
		o.setExpectedTime(s.getExpectedTime());
		o.setDeliveryArea(s.getDeliveryArea());
		o.setStatus(s.getStatus());
		dao.getNewOrder(o);
		return s;
		
		
	}

	@Override
	public OrderDTO updateOrder(int orderId, OrderDTO o) {
		Order p=dao.getOderByID(orderId);
		p.setOrderId(o.getOrderId());
		p.setBuyerId(o.getBuyerId());
		p.setBuyerName(o.getBuyerName());
		p.setAmount(o.getAmount());
		p.setOrderDate(o.getOrderDate());
		p.setExpectedTime(o.getExpectedTime());
		p.setDeliveryArea(o.getDeliveryArea());
		p.setStatus(o.getStatus());
		dao.getNewOrder(p);
		return o;
		
		
		
	}

	@Override
	public OrderDTO deleteOrder(int orderId) {
		Order o=dao.getOderByID(orderId);
		dao.deleteOrder(o);
		return null;
		
	}

}
