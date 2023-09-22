package com.udt.udt_dip.contract.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContractDiscount {

    private Long id;
    private Long contractId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private Long productDiscountId;
}