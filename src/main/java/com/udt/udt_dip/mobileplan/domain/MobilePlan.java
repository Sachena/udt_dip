package com.udt.udt_dip.mobileplan.domain;


import com.udt.udt_dip.mobileplandiscount.domain.MobilePlanDiscount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MobilePlan {

    private String id;

    private String name;

    private String price;

    private String description;

    public String calculatePrice(MobilePlanDiscount mobilePlanDiscount) {
        return String.valueOf(  Float.valueOf(this.getPrice()) -  (Float.valueOf(this.getPrice()) * mobilePlanDiscount.getRatio()) / 100);
    }

}
