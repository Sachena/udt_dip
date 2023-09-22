package com.udt.udt_dip.customer.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Customer {

    private Long id;
    private String name;
    private String residentNumber;
}
