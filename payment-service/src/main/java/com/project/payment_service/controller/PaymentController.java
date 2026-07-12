package com.project.payment_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment_service.dto.OrderStatusUpdateDTO;
import com.project.payment_service.dto.PaymentRequestDTO;
import com.project.payment_service.entity.Payment;
import com.project.payment_service.service.PaymentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	//create payment
	@PostMapping
	public ResponseEntity<Payment> processPayment(HttpServletRequest request, @Valid @RequestBody PaymentRequestDTO dto){
		
		String email = (String) request.getAttribute("email");
		return ResponseEntity.ok(service.processPayment(dto));
	}

}
