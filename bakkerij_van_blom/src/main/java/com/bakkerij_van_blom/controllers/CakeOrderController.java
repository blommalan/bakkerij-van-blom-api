package com.bakkerij_van_blom.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.bakkerij_van_blom.models.CakeOrder;
import com.bakkerij_van_blom.repositories.CakeOrderRepository;
import com.bakkerij_van_blom.services.CakeOrderService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cake-order")
public class CakeOrderController {

    @Autowired
    CakeOrderRepository cakeOrderRepository;

    @Autowired
    CakeOrderService cakeOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<CakeOrder>> getAllOrders() {
        try {
            List<CakeOrder> cakeOrders = new ArrayList<CakeOrder>();
            cakeOrderRepository.findAll().forEach(cakeOrders::add);

            if (cakeOrders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cakeOrders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/fulfil/{id}")
    public ResponseEntity<String> fulfilCakeOrder(@RequestParam Long id) {
        try {
            boolean fulfilCakeOrderResponse = cakeOrderService.fulfilOrder(id);

            if (!fulfilCakeOrderResponse) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // @GetMapping("/all")
    // public Iterable<CakeOrder> getAll() {
    //     return cakeOrderRepository.findAll();
    // }
}
