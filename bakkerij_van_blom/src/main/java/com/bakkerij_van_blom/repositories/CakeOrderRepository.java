package com.bakkerij_van_blom.repositories;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakkerij_van_blom.models.CakeOrder;

@Repository
public interface CakeOrderRepository extends JpaRepository<CakeOrder, Long> {
    CakeOrder findByUserId(Long userId);
    CakeOrder findByDeliveryDate(Date deliveryDate);
}