package com.hackathon.Tracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hackathon.Tracker.Entity.Order;
import com.hackathon.Tracker.dto.OrderDTO;


@Repository
public class OrderDAOImpl implements OrderDAO {
	@PersistenceContext
	EntityManager entitymanager;
	

	@Override
	public List<Order> getAllOrders() {
		Query query =entitymanager.createQuery("from Order");
        List<Order>  res = query.getResultList();
        return res;
       
	}


	@Override
	public Order getOderByID(int orderId) {
		Order o=entitymanager.find(Order.class, orderId);
		return o;
		
	}


	@Override
	public List<Order> getOrderByStatus(String status) {
		Query q=entitymanager.createQuery("from Order a where a.status=:status",Order.class);
		q.setParameter("status",status);
		List<Order> l=q.getResultList();
		return l;
//		
		
		//try {
//			Order s=(Order)m.getResultList();
//			return s;
//			}
//		catch(Exception ex) {
//			ex.printStackTrace();
//			return null;
//	}

}


	@Override
	@Transactional
	public Order getNewOrder(Order s) {
		entitymanager.persist(s);
		return null;
	}


	@Override
	@Transactional
	public Order deleteOrder(Order o) {
		entitymanager.remove(o);
		return null;
	}
}
