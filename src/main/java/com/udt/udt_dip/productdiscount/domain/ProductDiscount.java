package com.udt.udt_dip.productdiscount.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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