package com.udt.udt_dip.contract.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "contract")
public class ContractJpaEntity {

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


}
