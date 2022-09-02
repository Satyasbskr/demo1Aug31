package com.example.demo1aug31.controllers;

import com.example.demo1aug31.entities.Order;
import com.example.demo1aug31.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;
import java.util.Optional;
@RestController
@RequestMapping("/operations")
public class HelloController {
    private final OrderRepository orderRepository;
    @Autowired
    public HelloController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOperation(@PathVariable Long orderId) {
        Optional<Order> getOrder= orderRepository.findById(orderId);
        if (getOrder.isPresent())
        {
            return new ResponseEntity<>(getOrder.get(),HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> postOperation(@RequestBody Order newOrder) {
        Order order = orderRepository.save(newOrder);
        if (order == null) {
            throw new ServerErrorException("Order not created");
        } else {
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        }
    }
    @DeleteMapping
    public String deleteOperation() {
        return "Delete";
    }
    @PutMapping
    public String putOperation() {
        return "Put";
    }
}