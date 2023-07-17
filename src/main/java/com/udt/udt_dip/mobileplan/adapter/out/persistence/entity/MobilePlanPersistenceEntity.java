package com.udt.udt_dip.mobileplan.adapter.out.persistence.entity;

import lombok.Getter;

import javax.persistence.*;


@Entity
@Table(name = "mobile_plan")
@Getter
public class MobilePlanPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String description;
}
