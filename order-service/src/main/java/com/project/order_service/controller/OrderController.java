package com.project.order_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.order_service.dto.OrderRequestDTO;
import com.project.order_service.entity.Order;
import com.project.order_service.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    // create order
    @PostMapping
    public ResponseEntity<Order> createOrder(HttpServletRequest request,
            @Valid @RequestBody OrderRequestDTO dto){

        String email = (String) request.getAttribute("email");

        return ResponseEntity.ok(service.createOrder(email, dto));
    }

    // get orders
    @GetMapping
    public ResponseEntity<List<Order>> getOrders(HttpServletRequest request) {

        String email = (String) request.getAttribute("email");
        String role = (String) request.getAttribute("role");

        return ResponseEntity.ok(service.getOrders(email, role));
    }
    
    @PostMapping("/update-status")
    public String updateStatus(@RequestBody Map<String, Object> request) {

        Long orderId = Long.valueOf(request.get("orderId").toString());
        String status = request.get("status").toString();

        service.updateOrderStatus(orderId, status);

        return "updated";
    }
    
    @GetMapping("/test")
    public String test() {
        return "Order Service Working";
    }
}