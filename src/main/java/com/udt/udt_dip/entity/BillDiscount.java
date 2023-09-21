package com.udt.udt_dip.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class BillDiscount {

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
