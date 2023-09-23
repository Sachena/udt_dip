package com.udt.udt_dip.contract.adapter.in.web.model;

import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.customer.domain.model.Customer;
import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
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
