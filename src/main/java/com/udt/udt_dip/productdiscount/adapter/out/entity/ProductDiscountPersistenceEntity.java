package com.udt.udt_dip.productdiscount.adapter.out.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "product_discount")
@Entity
public class ProductDiscountPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private String type;
    private String name;
    private int price;
    private float ratio;
    private String description;
}
