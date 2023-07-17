package com.udt.udt_dip.contract.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class InUseMobilePhone {

    private Long mobilePhoneId;
    private String model;
    private String name;

    public static InUseMobilePhone generate(Long id, String model, String name) {
        return InUseMobilePhone.builder()
                .mobilePhoneId(id)
                .model(model)
                .name(name)
                .build();
    }
}
