package com.udt.udt_dip.contract.domain.model;

import com.udt.udt_dip.customer.domain.model.Customer;
import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;

@Getter
@Builder
public class Contract {

    private Long id;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private Contractor contractor;
    private InUseMobilePhone inUseMobilePhone;
    private SubscriptionMobilePlan subscriptionMobilePlan;
    private LocalDateTime contractChangeDatetime;
    private String communicationExpense;

    public void updateCommunicationExpense(String targetMobilePlanId) {
        this.communicationExpense = targetMobilePlanId;
    }

    public void updateInUseMobilePlan(String mobilePlanId) {

        if (StringUtils.isEmpty(mobilePlanId)) {
            throw new RuntimeException();
        }

        this.subscriptionMobilePlan.update(NumberUtils.toLong(mobilePlanId));
        this.contractChangeDatetime = LocalDateTime.now();
    }
}
