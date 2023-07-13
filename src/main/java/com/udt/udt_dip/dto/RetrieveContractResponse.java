package com.udt.udt_dip.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RetrieveContractResponse {

    private Long id;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private LocalDateTime contractChangeDatetime;
    private String communicationExpense;
    private String customerName;
    private String mobilePhoneModel;
    private String mobilePhoneName;
    private String mobilePlanName;
    private String mobilePlanPrice;
}
