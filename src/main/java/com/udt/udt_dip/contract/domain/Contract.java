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

    private Long customerId;

    private Long mobilePhoneId;

    private Long mobilePlanId;

    private LocalDateTime contractChangeDatetime;

    private String communicationExpense;

    public void updateMobilePlan(String targetMobilePlanId) {
        this.mobilePlanId = NumberUtils.toLong(targetMobilePlanId);
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateCommunicationExpense(String targetMobilePlanId) {
        this.communicationExpense = targetMobilePlanId;
    }

}
