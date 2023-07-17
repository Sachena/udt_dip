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

    public static RetrieveContractResponse generateResponseByDomain(Contract contract, Customer customer,
        MobilePhone mobilePhone, MobilePlan mobilePlan) {
        RetrieveContractResponse retrieveContractResponse = new RetrieveContractResponse();
        retrieveContractResponse.setContractId(ObjectUtils.toString(contract.getId()));
        retrieveContractResponse.setPhoneNumber(contract.getPhoneNumber());
        retrieveContractResponse.setFirstContractDate(contract.getFirstContractDate());
        retrieveContractResponse.setContractChangeDatetime(contract.getContractChangeDatetime());
        retrieveContractResponse.setCommunicationExpense(contract.getCommunicationExpense());
        retrieveContractResponse.setCustomerName(customer.getName());
        retrieveContractResponse.setMobilePhoneModel(mobilePhone.getModel());
        retrieveContractResponse.setMobilePhoneName(mobilePhone.getName());
        retrieveContractResponse.setMobilePlanName(mobilePlan.getName());
        retrieveContractResponse.setMobilePlanPrice(mobilePlan.getPrice());

        return retrieveContractResponse;
    }
}
