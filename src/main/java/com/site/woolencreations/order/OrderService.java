package com.site.woolencreations.order;

import com.site.woolencreations.category.Category;
import com.site.woolencreations.product.Product;
import com.site.woolencreations.product.ProductRepository;
import com.site.woolencreations.user.User;
import com.site.woolencreations.user.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Order> findOrderByUserID(Long userID) {
        return orderRepository.findOrderByUserID(userID);
    }

    public List<Product> findProductIdsByUserOrderingHistory(Long customerId) {
        return orderRepository.findProductIdsByUserOrderingHistory(customerId);

    }

    private List<Product> customerTargetedProducts(List<String> preferedCategoryNames, List<Double> preferedPrice, List<Integer> preferedProductPoints) {

        return null;

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
    public Order addOrder(Order order, Long userID) {
        Date now = new Date();

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
        return orderRepository.save(order);
    }
}
