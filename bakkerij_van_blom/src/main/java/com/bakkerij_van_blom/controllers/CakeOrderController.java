package com.bakkerij_van_blom.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.bakkerij_van_blom.models.CakeOrder;
import com.bakkerij_van_blom.repositories.CakeOrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cake-order")
public class CakeOrderController {

    private CakeOrderRepository cakeOrderRepository;

    @Autowired
    public CakeOrderController(CakeOrderRepository repository) {
        this.cakeOrderRepository = repository;
    }

    // @GetMapping("/{id}")
    // public CakeOrder getCakeOrder(@PathVariable Long id) {
    //     return cakeOrderRepository.findById(id);
    // }

    @GetMapping("/all")
    public Iterable<CakeOrder> getAll() {
        return cakeOrderRepository.findAll();
    }
}
