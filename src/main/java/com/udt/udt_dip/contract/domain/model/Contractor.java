package com.udt.udt_dip.contract.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class Contractor {

    private Long customerId;
    private String name;

    public static Contractor generate(Long id, String name) {
        return Contractor.builder()
                .customerId(id)
                .name(name)
                .build();
    }
}
