package com.udt.udt_dip.contract.repository;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contract_discount")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractDiscountJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contractId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private Long productDiscountId;
}
