package com.udt.udt_dip.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    }

    public void updateFinalCommunicationExpense(String targetMobilePlanId) {
        this.mobilePlanId = targetMobilePlanId;
    }
}
