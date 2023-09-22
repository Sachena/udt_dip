package com.udt.udt_dip.mobileplan.domain;


import com.udt.udt_dip.productdiscount.domain.ProductDiscount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MobilePlan {

    private Long id;
    private String name;
    private int price;
    private String description;

}
