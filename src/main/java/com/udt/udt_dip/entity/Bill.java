package com.udt.udt_dip.entity;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contractId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private Long billDiscountId;
    private float basePrice;
    private float actualPrice;
    private float discountPrice;
}
