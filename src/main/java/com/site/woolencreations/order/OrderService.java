package com.site.woolencreations.order;

import com.site.woolencreations.user.User;
import com.site.woolencreations.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    /**
     * Find Order By UserID
     * return order
     */
    public Optional<Order> findOrderByUserID(Long userID) {
        return orderRepository.findOrderByUserID(userID);
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
        Date date = new Date(System.currentTimeMillis());
        Optional<User> user = userRepository.findUserByID(userID);
        if(user.isPresent()){
        order.setUser(user.get());
        order.setDate(date);
        }
        else{
            throw new IllegalStateException("The user does not exists!! ");
        }
        orderRepository.save(order);
    }
}
