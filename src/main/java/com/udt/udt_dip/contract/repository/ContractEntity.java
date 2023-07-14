package com.udt.udt_dip.contract.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
public class ContractEntity {

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





}
