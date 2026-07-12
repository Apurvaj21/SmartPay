package com.project.order_service.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.order_service.dto.OrderRequestDTO;
import com.project.order_service.entity.Order;
import com.project.order_service.exception.OrderNotFoundException;
import com.project.order_service.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	//Create Order
	public Order createOrder(String email, OrderRequestDTO dto) {
		Order order = new Order();
		
		order.setUserEmail(email);
		order.setProductName(dto.getProductName());
		order.setAmount(dto.getAmount());
		order.setStatus("CREATED");
		
		return repo.save(order);
	}
	
	//Get Orders
	public List<Order> getOrders(String email, String role){
		if(role.equals("ADMIN")) {
			return repo.findAll(); //for admin
		}
		else {
			return repo.findByUserEmail(email); //for user
		}
	}
	public void updateOrderStatus(Long orderId, String status) {
	    Order order = repo.findById(orderId)
	    		.orElseThrow(() -> new OrderNotFoundException("Order not found"));

	    order.setStatus(status);
	    repo.save(order);
	}
}
