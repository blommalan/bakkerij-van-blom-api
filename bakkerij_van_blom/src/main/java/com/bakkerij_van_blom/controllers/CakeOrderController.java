package com.bakkerij_van_blom.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.bakkerij_van_blom.models.CakeOrder;
import com.bakkerij_van_blom.repositories.CakeOrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cake-order")
public class CakeOrderController {

    @Autowired
    CakeOrderRepository cakeOrderRepository;

    @GetMapping("/all")
    public List<CakeOrder> getAllOrders() {
        return cakeOrderRepository.findAll();
        // try {
        //     List<CakeOrder> cakeOrders = new ArrayList<CakeOrder>();


        //     cakeOrderRepository.findAll().forEach(cakeOrders::add);

        //     if (cakeOrders.isEmpty()) {
                
        //         System.out.println("Nothing found");
        //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //     }

            
        //     System.out.println("Success");
        //     return new ResponseEntity<>(cakeOrders, HttpStatus.OK);
        // } catch (Exception e) {
        //     System.out.println(e);
        //     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    // @GetMapping("/all")
    // public Iterable<CakeOrder> getAll() {
    //     return cakeOrderRepository.findAll();
    // }
}
