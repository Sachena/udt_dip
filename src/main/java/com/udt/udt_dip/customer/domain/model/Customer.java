package com.udt.udt_dip.customer.domain.model;

import lombok.Builder;

@Builder
public class Customer {

    private Long id;
    private String name;
    private String residentNumber;
}
