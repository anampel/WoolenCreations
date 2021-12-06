package com.site.woolencreations.order;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Find Order By UserID
     * return order
     */
    public Optional<Order> findOrderByUserID(Long userID) {
        return null;// orderRepository.findOrderByUserID(userID);
    }

    /**
     * Find Order By Date
     * return list of Orders
     * */


    /**
     * Find Order By Status
     * return list of Orders
     * */


    /**
     * Add an order
     */
    public void addOrder(Order order, Long userID) {
//        Date date = new Date(System.currentTimeMillis());
//        orderRepository.insertOrder(userID, date, order.getPhone(), order.getPaid(), order.getState(),
//                order.getShipping_company_name(), order.getShipping_cost());
    }
}
