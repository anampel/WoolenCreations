package com.site.woolencreations.order;

import com.site.woolencreations.product.Product;
import com.site.woolencreations.product.ProductRepository;
import com.site.woolencreations.user.User;
import com.site.woolencreations.user.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
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
     */
    public List<Order> findOrderByDate(Date date) {
        return orderRepository.findOrderByDate(date);
    }

    /**
     * Find Order By State
     * return list of Orders
     */
    public Optional<Order> findOrderByState(String state) {
        return orderRepository.findOrderByState(state);
    }

    /**
     * Add an order
     */
    @SneakyThrows
    public void addOrder(Order order, Long userID) {
//        Date date = new Date(System.currentTimeMillis());
//        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        simpleDateFormat.format(now, stringBuffer, new FieldPosition(0));

        Optional<User> user = userRepository.findUserByID(userID);
        if (user.isPresent()) {
            order.setUser(user.get());
            order.setDate(now);
        } else {
            throw new IllegalStateException("The user does not exists!! ");
        }
        for (int i = 0; i < order.getOrderProduct().size(); i++) {
            Optional<Product> product = productRepository.findProductById(order.getOrderProduct().get(i).getProduct().getId());
            if (product.isPresent()) {
                order.getOrderProduct().get(i).setProduct(product.get());
                order.getOrderProduct().get(i).setQuantity(order.getOrderProduct().get(i).getQuantity());
            } else {
                throw new IllegalStateException("The product does not exists!! ");
            }
        }
        orderRepository.save(order);
    }
}
