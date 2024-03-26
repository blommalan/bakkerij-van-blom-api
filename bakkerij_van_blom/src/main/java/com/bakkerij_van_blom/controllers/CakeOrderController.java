package com.bakkerij_van_blom.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.bakkerij_van_blom.dtos.CakeOrderDto;
import com.bakkerij_van_blom.models.CakeOrder;
import com.bakkerij_van_blom.repositories.CakeOrderRepository;
import com.bakkerij_van_blom.services.CakeOrderService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cake-order")
public class CakeOrderController {

    @Autowired
    CakeOrderRepository cakeOrderRepository;

    @Autowired
    CakeOrderService cakeOrderService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<CakeOrder>> getOrdersByUserId(@RequestParam Long id) {
        List<CakeOrder> cakeOrders = cakeOrderService.retrieveOrdersByUser(id);

        if (cakeOrders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cakeOrders, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CakeOrder>> getAllOrders() {
        List<CakeOrder> cakeOrders = cakeOrderService.retrieveAllOrders();

        if (cakeOrders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cakeOrders, HttpStatus.OK);
    }

    @PutMapping("/fulfil/{id}")
    public ResponseEntity<String> fulfilCakeOrder(@RequestParam Long id) {
        cakeOrderService.fulfilOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> saveNewCakeOrder(@RequestBody CakeOrderDto cakeOrder) {
        cakeOrderService.logNewCakeOrder(cakeOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
