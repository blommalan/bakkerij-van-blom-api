package com.bakkerij_van_blom.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakkerij_van_blom.dtos.CakeOrderDto;
import com.bakkerij_van_blom.exceptions.CannotSaveOrderException;
import com.bakkerij_van_blom.exceptions.OrderNotFoundException;
import com.bakkerij_van_blom.models.CakeOrder;
import com.bakkerij_van_blom.repositories.CakeOrderRepository;

@Service
public class CakeOrderService {
    
    @Autowired
    private CakeOrderRepository cakeOrderRepository;

    public List<CakeOrder> retrieveAllOrders() {
        List<CakeOrder> cakeOrders = new ArrayList<CakeOrder>();
        cakeOrderRepository.findAll().forEach(cakeOrders::add);
        return cakeOrders;
    }

    public void fulfilOrder(Long id) {
        Optional<CakeOrder> cakeOrder = cakeOrderRepository.findById(id);
        if (!cakeOrder.isPresent()) {
            throw new OrderNotFoundException(id);
        }

        cakeOrder.get().fulfilledDate = new Date();
        cakeOrderRepository.save(cakeOrder.get());
    }

    public void logNewCakeOrder(CakeOrderDto cakeOrderDto) {
        try {
            CakeOrder cakeOrder = new CakeOrder(cakeOrderDto);
            cakeOrderRepository.save(cakeOrder);
        } catch (Exception e) {
            throw new CannotSaveOrderException(e.getMessage());
        }
    }

}
