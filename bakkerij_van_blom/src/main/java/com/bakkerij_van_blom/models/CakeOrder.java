package com.bakkerij_van_blom.models;
import java.util.Date;

import jakarta.persistence.*; // All package required for the entity class

@Entity
@Table(name = "cake_orders")
public class CakeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="user_id")
    private Long userId;
    
    @Column(name="cake_flavour")
    private String cakeFlavour;

    private String allergens;
    private String notes;
    
    @Column(name="delivery_address")
    private Long deliveryAddress;

    @Column(name="order_date")
    private Date orderDate;
    
    @Column(name="delivery_date")
    private Date deliveryDate;
    
    @Column(name="fulfilled_date")
    private Date fulfilledDate;
    
    // Getters and setters
}