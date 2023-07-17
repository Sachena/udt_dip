package com.udt.udt_dip.mobilephone.adapter.out.persistence.entity;

import lombok.Getter;

import javax.persistence.*;


@Entity
@Table(name = "mobile_phone")
@Getter
public class MobilePhonePersitenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private String name;
    private String usim;
    private String description;
    private String price;
}
