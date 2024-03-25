package com.bakkerij_van_blom.models;
import java.util.Date;

import jakarta.persistence.*; // All package required for the entity class

@Entity
@Table(name = "cake_orders")
public class CakeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @Column(name="user_id")
    public Long userId;
    
    @Column(name="cake_flavour")
    public String cakeFlavour;

    public String allergens;
    public String notes;
    
    @Column(name="delivery_address")
    public Long deliveryAddress;

    @Column(name="order_date")
    public Date orderDate;
    
    @Column(name="delivery_date")
    public Date deliveryDate;
    
    @Column(name="fulfilled_date")
    public Date fulfilledDate;
    
}