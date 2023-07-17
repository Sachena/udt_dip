package com.udt.udt_dip.contract.adapter.in.web.model;

import com.udt.udt_dip.contract.domain.model.Contract;
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
    private String communicationExpense;
    private String customerName;
    private String mobilePhoneModel;
    private String mobilePhoneName;
    private String mobilePlanName;
    private String mobilePlanPrice;

    public static RetrieveContractResponse generateByDomain(Contract contract) {
        RetrieveContractResponse retrieveContractResponse = new RetrieveContractResponse();
        retrieveContractResponse.setContractId(String.valueOf(contract.getId()));
        retrieveContractResponse.setPhoneNumber(contract.getPhoneNumber());
        retrieveContractResponse.setFirstContractDate(contract.getFirstContractDate());
        retrieveContractResponse.setContractChangeDatetime(contract.getContractChangeDatetime());
        retrieveContractResponse.setCommunicationExpense(contract.getCommunicationExpense());
        retrieveContractResponse.setCustomerName(contract.getContractor().getName());
        retrieveContractResponse.setMobilePhoneModel(contract.getInUseMobilePhone().getModel());
        retrieveContractResponse.setMobilePhoneName(contract.getInUseMobilePhone().getName());
        retrieveContractResponse.setMobilePlanName(contract.getSubscriptionMobilePlan().getName());
        retrieveContractResponse.setMobilePlanPrice(contract.getSubscriptionMobilePlan().getPrice());

        return retrieveContractResponse;
    }
}
