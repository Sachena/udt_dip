package com.udt.udt_dip.entity;

import lombok.Getter;

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

    private String customerId;

    private String mobilePhoneId;

    private String mobilePlanId;

    private LocalDateTime contractChangeDatetime;

    private String communicationExpense;

    public void updateMobilePlan(String targetMobilePlanId) {
        this.mobilePlanId = targetMobilePlanId;
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateCommunicationExpense(String targetMobilePlanId) {
        this.communicationExpense = targetMobilePlanId;
    }
}
