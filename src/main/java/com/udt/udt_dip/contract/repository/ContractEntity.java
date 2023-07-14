package com.udt.udt_dip.contract.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="contract")
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
