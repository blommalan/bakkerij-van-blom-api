package com.bakkerij_van_blom.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakkerij_van_blom.dtos.CakeOrderDto;
import com.bakkerij_van_blom.models.CakeOrder;
import com.bakkerij_van_blom.repositories.CakeOrderRepository;

@Service
public class CakeOrderService {
    
    @Autowired
    private CakeOrderRepository cakeOrderRepository;

    public boolean fulfilOrder(Long id) {
        Optional<CakeOrder> cakeOrder = cakeOrderRepository.findById(id);
        if (cakeOrder.isPresent()) {
            cakeOrder.get().fulfilledDate = new Date();
            cakeOrderRepository.save(cakeOrder.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean logNewCakeOrder(CakeOrderDto cakeOrderDto) {
        try {
            CakeOrder cakeOrder = new CakeOrder(cakeOrderDto);
            System.out.println(cakeOrder.id);
            cakeOrderRepository.save(cakeOrder);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
