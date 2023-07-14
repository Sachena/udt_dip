package com.udt.udt_dip.contract.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    private Long id;

    private String phoneNumber;

    private LocalDateTime firstContractDate;

    private String customerId;

    private String mobilePhoneId;

    private String mobilePlanId;

    private LocalDateTime contractChangeDatetime;

    private String communicationExpense;

    public void updateMobilePlan(String targetMobilePlanId) {
        this.mobilePlanId = targetMobilePlanId;
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateCommunicationExpense(String targetMobilePlanId) {
        this.communicationExpense = targetMobilePlanId;
    }

}
