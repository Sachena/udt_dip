package com.udt.udt_dip.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommunicationExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractId;

    private String mobilePhoneId;

    private String mobilePlanId;

    private String finalCommunicationExpense;

}
