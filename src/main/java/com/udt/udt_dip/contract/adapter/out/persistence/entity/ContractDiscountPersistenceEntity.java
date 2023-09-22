package com.udt.udt_dip.contract.adapter.out.persistence.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@Table(name = "contract_discount")
@Entity
public class ContractDiscountPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contractId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private Long productDiscountId;
}
