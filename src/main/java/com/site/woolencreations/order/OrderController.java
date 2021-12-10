package com.site.woolencreations.order;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static com.site.woolencreations.order.OrderConfig.dateFormat;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/findOrderByUserID")
    public Optional<Order> findOrderByUserID(@RequestParam Long userID) {
        return orderService.findOrderByUserID(userID);
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order, @RequestParam Long userID){
        orderService.addOrder(order, userID);
        return "success";
    }

    @GetMapping("/findOrderByState")
    public Optional<Order> findOrderByState(@RequestParam String state){
        return orderService.findOrderByState(state);
    }

    @SneakyThrows
    @GetMapping("findOrderByDate")
    public List<Order> findOrderByDate(@RequestParam String date){
        return orderService.findOrderByDate(new SimpleDateFormat(dateFormat).parse(date));
    }
    //TODO sortByDate
}
//@DateTimeFormat(pattern = "yyyy-MM-dd") Date