package com.udt.udt_dip.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ContractHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    //private String contractId;

    private String phoneNumber;

    private LocalDateTime firstContractDate;

    private String customerId;

    private String mobilePhoneId;

    private String mobilePlanId;

    private LocalDateTime contractHistoryStartDatetime;

    private LocalDateTime contractHistoryEndDatetime;

}
