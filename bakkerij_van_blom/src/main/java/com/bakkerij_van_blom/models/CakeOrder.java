package com.bakkerij_van_blom.models;
import java.util.Date;

import com.bakkerij_van_blom.dtos.CakeOrderDto;

import jakarta.persistence.*; // All package required for the entity class

@Entity
@Table(name = "cake_orders")
public class CakeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public CakeOrder() {

    }

    public CakeOrder(Long userId, String cakeFlavour, String allergens, String notes, Long deliveryAddress, Date orderDate, Date deliveryDate, Date fulfilledDate) {
        this.id = null;
        this.userId = userId;
        this.cakeFlavour = cakeFlavour;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate; 
        this.orderDate = orderDate;
        this.fulfilledDate = fulfilledDate;
        this.allergens = allergens;
        this.notes = notes;        
    }

    public CakeOrder(CakeOrderDto cakeOrderDto) {
        this.id = null;
        this.userId = cakeOrderDto.userId;
        this.cakeFlavour = cakeOrderDto.cakeFlavour;
        this.deliveryAddress = cakeOrderDto.deliveryAddress;
        this.deliveryDate = cakeOrderDto.deliveryDate; 
        this.orderDate = cakeOrderDto.orderDate;
        this.allergens = cakeOrderDto.allergens;
        this.notes = cakeOrderDto.notes;  
        this.fulfilledDate = null;      
    }
    
}