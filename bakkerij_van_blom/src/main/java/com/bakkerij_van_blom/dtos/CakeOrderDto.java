package com.bakkerij_van_blom.dtos;

import java.util.Date;

public class CakeOrderDto {
    
    public Long userId;
    
    public String cakeFlavour;

    public String allergens;
    public String notes;
    
    public Long deliveryAddress;

    public Date orderDate;
    
    public Date deliveryDate;
}
