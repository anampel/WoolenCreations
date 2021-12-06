package com.site.woolencreations.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Modifying
    @Query(value = "insert into ORDER (user_id, date, phone, paid, state, shipping_company_name, shipping_cost) VALUES (:user_id, :date, :phone, :paid, :state, :shipping_company_name, :shipping_cost)", nativeQuery = true)
    @Transactional
    void insertOrder(Long user_id, Date date, String phone, Boolean paid, String state, String shipping_company_name, Double shipping_cost);

    @Query("SELECT o FROM Order o WHERE o.user.id =?1")
    Optional<Order> findOrderByUserID(Long userID);
}
