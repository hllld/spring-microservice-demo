package com.demo.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.order.exception.ResourceNotFoundException;
import com.demo.order.model.Order;
import com.demo.order.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
    	return orderRepository.findById(id)
		.orElseThrow(() ->
				new ResourceNotFoundException("Order not found with id: " + id));
//        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
