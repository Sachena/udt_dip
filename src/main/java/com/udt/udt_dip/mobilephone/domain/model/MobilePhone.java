package com.udt.udt_dip.mobilephone.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MobilePhone {

    private Long id;
    private String manufacturer;
    private String model;
    private String name;
    private String usim;
    private String description;
    private String price;
}
