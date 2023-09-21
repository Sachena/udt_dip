package com.udt.udt_dip.dto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateMobilePlanRequest {

    private String targetContractId;
    private String targetMobilePlanId;
    private List<String> billDiscountIdList;
}
