package com.bakkerij_van_blom.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakkerij_van_blom.models.CakeOrder;

@Repository
public interface CakeOrderRepository extends JpaRepository<CakeOrder, Long> {
    List<CakeOrder> findByUserId(Long userId);
    List<CakeOrder> findByDeliveryDate(Date deliveryDate);
}