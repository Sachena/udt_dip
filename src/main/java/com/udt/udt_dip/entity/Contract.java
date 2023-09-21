package com.udt.udt_dip.entity;

import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private Long customerId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private Long mobilePlanDiscountId;
    private LocalDateTime contractChangeDatetime;
    private float communicationExpense;

    public void updateMobilePlan(String targetMobilePlanId) {
        this.mobilePlanId = NumberUtils.toLong(targetMobilePlanId);
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateCommunicationExpense(float communicationExpense) {
        this.communicationExpense = communicationExpense;
    }



}
