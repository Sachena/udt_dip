package com.udt.udt_dip.mobileplandiscount.repository;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "mobile_plan_discount")
public class MobilePlanDiscountJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mobilePlanId;
    private String name;
    private float ratio;
    private String description;

}
