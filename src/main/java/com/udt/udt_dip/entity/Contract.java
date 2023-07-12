package com.udt.udt_dip.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private String finalCommunicationExpense;

    public void updateMobilePlan(String targetMobilePlanId) {
        this.mobilePlanId = targetMobilePlanId;
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateFinalCommunicationExpense(String targetMobilePlanId) {
        this.finalCommunicationExpense = targetMobilePlanId;
    }
}
