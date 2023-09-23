package com.udt.udt_dip.contract.adapter.in.web.model;

import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.customer.domain.model.Customer;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RetrieveContractInUseMobilePlan {

    private String contractId;
    private String phoneNumber;
    private LocalDateTime contractChangeDatetime;
    private String customerName;
    private String mobilePlanName;
    private String mobilePlanPrice;

    public RetrieveContractInUseMobilePlan(Contract contract, Customer customer,
        MobilePlan mobilePlan) {
        this.contractId = String.valueOf(contract.getId());
        this.phoneNumber = contract.getPhoneNumber();
        this.contractChangeDatetime = contract.getContractChangeDatetime();
        this.customerName = customer.getName();
        this.mobilePlanName = mobilePlan.getName();
        this.mobilePlanPrice = String.valueOf(mobilePlan.getPrice());
    }
}
