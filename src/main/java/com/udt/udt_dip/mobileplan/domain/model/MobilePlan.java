package com.udt.udt_dip.mobileplan.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MobilePlan {

    private Long id;
    private String name;
    private String price;
    private String description;
}
