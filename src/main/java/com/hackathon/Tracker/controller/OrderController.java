package com.hackathon.Tracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.Tracker.dto.OrderDTO;
import com.hackathon.Tracker.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getAllOrders(){
		return service.getAllOrders();
		
	}
	
	@GetMapping(value="order/id/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO getOrderById(@PathVariable(name="id") Integer orderId) {  
		logger.info("Request for Order view by Buyer {}", orderId);
		return service.getOrderById(orderId);
	}
	
	@GetMapping(value="order/status/{status}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getByStatus(@PathVariable(name="status") String status) {
		logger.info("Request for Order view by Buyer {}", status);
		return service.getByStatus(status);
	}
	
	@PostMapping(value="/new",consumes= MediaType.APPLICATION_JSON_VALUE)
	public String getNewOrder(@RequestBody OrderDTO s ) {
		logger.info("Request for order removal by buyer {}", s);
		service.getNewOrder(s);
		return "Added Successfully";
		
	}
	
	@PutMapping(value="/update/id/{id}",consumes= MediaType.APPLICATION_JSON_VALUE)
	public String updateOrder(@PathVariable(name="id") int orderId,@RequestBody OrderDTO o) {
		service.updateOrder(orderId,o);
		return "Updated Successfully";
	}
	
	@DeleteMapping(value="delete/orderId/{id}",consumes= MediaType.APPLICATION_JSON_VALUE)
	public String deleteOrder(@PathVariable(name="id") Integer orderId) {
		logger.info("Request for order removal by buyer {}", orderId);
		service.deleteOrder(orderId);
		return "Deleted Successfully";
		
	}
	
	
	
}
