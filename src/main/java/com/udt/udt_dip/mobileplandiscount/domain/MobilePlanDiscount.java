package com.udt.udt_dip.mobileplandiscount.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MobilePlanDiscount {
    private Long id;
    private Long mobilePlanId;
    private String name;
    private float ratio;
    private String description;
}
