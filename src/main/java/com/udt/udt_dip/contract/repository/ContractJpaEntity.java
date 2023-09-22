package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contract")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private Long customerId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private LocalDateTime contractChangeDatetime;

    public void update(Contract contract) {
        this.id = contract.getId();
        this.phoneNumber = contract.getPhoneNumber();
        this.firstContractDate = contract.getFirstContractDate();
        this.customerId = contract.getCustomerId();
        this.mobilePhoneId = contract.getMobilePhoneId();
        this.mobilePlanId = contract.getMobilePlanId();
        this.contractChangeDatetime = contract.getContractChangeDatetime();
    }
}
