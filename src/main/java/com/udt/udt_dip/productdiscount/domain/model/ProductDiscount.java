package com.udt.udt_dip.productdiscount.domain.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Builder
@Getter
public class ProductDiscount {

    private Long id;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private String type;
    private String name;
    private int price;
    private float ratio;
    private String description;
}
