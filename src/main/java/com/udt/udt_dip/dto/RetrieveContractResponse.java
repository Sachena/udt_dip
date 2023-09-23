package com.udt.udt_dip.dto;

import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.entity.Customer;
import com.udt.udt_dip.entity.MobilePhone;
import com.udt.udt_dip.entity.MobilePlan;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RetrieveContractResponse {

    private String contractId;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private LocalDateTime contractChangeDatetime;
    private String customerName;
    private String mobilePhoneModel;
    private String mobilePhoneName;
    private String mobilePlanName;
    private String mobilePlanPrice;
    private String contractBillAmount;

    public RetrieveContractResponse(Contract contract, Customer customer, MobilePhone mobilePhone,
        MobilePlan mobilePlan, float contractBillAmount) {

        this.contractId = String.valueOf(contract.getId());
        this.phoneNumber = contract.getPhoneNumber();
        this.firstContractDate = contract.getFirstContractDate();
        this.contractChangeDatetime = contract.getContractChangeDatetime();
        this.customerName = customer.getName();
        this.mobilePhoneModel = mobilePhone.getModel();
        this.mobilePhoneName = mobilePhone.getName();
        this.mobilePlanName = mobilePlan.getName();
        this.mobilePlanPrice = String.valueOf(mobilePlan.getPrice());
        this.contractBillAmount = String.valueOf(contractBillAmount);
    }
}
