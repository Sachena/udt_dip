package com.udt.udt_dip.mobileplan.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MobilePlan {

    private Long id;

    private String name;

    private String price;

    private String description;

    public String calculatePrice() {
        return this.getPrice();
    }

}
