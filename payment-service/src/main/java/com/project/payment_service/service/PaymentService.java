package com.project.payment_service.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.payment_service.dto.PaymentRequestDTO;
import com.project.payment_service.entity.Payment;
import com.project.payment_service.exception.PaymentAlreadyExistsException;
import com.project.payment_service.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository repo;
	
	@Autowired
    private RestTemplate restTemplate;

   

    public Payment processPayment(PaymentRequestDTO dto) {

        // 1. check if already paid
        if (repo.findByOrderId(dto.getOrderId()).isPresent()) {
        	throw new PaymentAlreadyExistsException("Payment already done for this order");
        }

        // 2. create payment object
        Payment payment = new Payment();
        payment.setOrderId(dto.getOrderId());
        payment.setAmount(dto.getAmount());
        payment.setCreatedAt(LocalDateTime.now());

        // 3. simulate payment
        boolean success = new Random().nextBoolean();

        if (success) {
            payment.setStatus("SUCCESS");
        } else {
            payment.setStatus("FAILED");
        }

        // 4. save payment
        Payment savedPayment = repo.save(payment);

        // 5. update order status (inter-service call)
        updateOrderStatus(savedPayment);

        return savedPayment;
    }

    
    private void updateOrderStatus(Payment payment) {

        String url = "http://localhost:8082/orders/update-status";

        Map<String, Object> request = new HashMap<>();
        request.put("orderId", payment.getOrderId());
        request.put("status", payment.getStatus());

        try {
            String response = restTemplate.postForObject(url, request, String.class);
            System.out.println("Order updated successfully: " + response);
        } catch (Exception e) {
            System.out.println("ERROR calling Order Service: " + e.getMessage());
        }
    }
}