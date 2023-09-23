package com.udt.udt_dip.contract.dto;

import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.customer.domain.Customer;
import com.udt.udt_dip.mobilephone.domain.MobilePhone;
import com.udt.udt_dip.mobileplan.domain.MobilePlan;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDateTime;

@Data
public class RetrieveContractResponse {

    private String contractId;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private LocalDateTime contractChangeDatetime;
    private String communicationExpense;
    private String customerName;
    private String mobilePhoneModel;
    private String mobilePhoneName;
    private String mobilePlanName;
    private String mobilePlanPrice;

    public RetrieveContractResponse(Contract contract, Customer customer, MobilePhone mobilePhone,
        MobilePlan mobilePlan, String communicationExpense) {
        this.contractId = String.valueOf(contract.getId());
        this.phoneNumber = mobilePhone.getId();
        this.firstContractDate = contract.getFirstContractDate();
        this.contractChangeDatetime = contract.getContractChangeDatetime();
        this.communicationExpense = communicationExpense;
        this.customerName = customer.getName();
        this.mobilePhoneModel = mobilePhone.getModel();
        this.mobilePhoneName = mobilePhone.getName();
        this.mobilePlanName = mobilePlan.getName();
        this.mobilePlanPrice = String.valueOf(mobilePlan.getPrice());

    }
}
