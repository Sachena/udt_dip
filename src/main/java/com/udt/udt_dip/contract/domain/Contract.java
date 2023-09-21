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

    private String id;

    private String phoneNumber;

    private LocalDateTime firstContractDate;

    private String customerId;

    private String mobilePhoneId;

    private String mobilePlanId;

    private String mobilePlanDiscountId;

    private LocalDateTime contractChangeDatetime;

    private String communicationExpense;

    public void updateMobilePlan(String mobilePlanId) {
        this.mobilePlanId = mobilePlanId;
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateCommunicationExpense(String mobilePlanId) {
        this.communicationExpense = mobilePlanId;
    }

}
