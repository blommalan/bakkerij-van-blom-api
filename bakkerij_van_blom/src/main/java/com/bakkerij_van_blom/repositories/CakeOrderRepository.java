package com.bakkerij_van_blom.repositories;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bakkerij_van_blom.models.CakeOrder;

@Repository
public interface CakeOrderRepository extends CrudRepository<CakeOrder, Long> {
    CakeOrder findByUserId(Long userId);
    CakeOrder findByDeliveryDate(Date deliveryDate);
}