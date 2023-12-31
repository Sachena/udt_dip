package com.udt.udt_dip.domain;

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

    private LocalDateTime contractChangeDatetime;

    private String communicationExpense;

    public void updateMobilePlan(String targetMobilePlanId) {
        this.mobilePlanId = NumberUtils.toLong(targetMobilePlanId);
        this.contractChangeDatetime = LocalDateTime.now();
    }

    public void updateCommunicationExpense(String targetMobilePlanId) {
        this.communicationExpense = targetMobilePlanId;
    }



}
