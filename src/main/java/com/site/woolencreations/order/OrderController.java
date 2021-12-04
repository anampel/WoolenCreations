package com.site.woolencreations.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //TODO findOrderByUserID
    @GetMapping("/findOrderByUserID")
    public Optional<Order> findOrderByUserID(@RequestParam Long userID){
        return orderService.findOrderByUserID(userID);
    }

    //TODO findOrderByDate
    //TODO add
    @PostMapping("/add")
    public String addOrder(@RequestBody Order order, @RequestParam Long userID){
        orderService.addOrder(order, userID);
        return "success";
    }
    //TODO findOrderByStatus
    //TODO orderByDate
}
