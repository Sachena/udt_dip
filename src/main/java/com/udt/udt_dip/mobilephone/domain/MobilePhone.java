package com.udt.udt_dip.mobilephone.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MobilePhone {

    private String id;
    private String manufacturer;
    private String model;
    private String name;
    private String usim;
    private String description;
    private String price;
}
