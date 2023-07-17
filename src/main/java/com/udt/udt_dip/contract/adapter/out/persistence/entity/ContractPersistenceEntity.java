package com.udt.udt_dip.contract.adapter.out.persistence.entity;

import com.udt.udt_dip.contract.domain.model.Contract;
import lombok.*;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contract")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractPersistenceEntity {

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


    public void updateByDomain(Contract contract) {
        this.id = contract.getId();
        this.phoneNumber = contract.getPhoneNumber();
        this.firstContractDate = contract.getFirstContractDate();
        this.customerId = contract.getContractor().getCustomerId();
        this.mobilePhoneId = contract.getInUseMobilePhone().getMobilePhoneId();
        this.mobilePlanId = contract.getSubscriptionMobilePlan().getMobilePlanId();
        this.contractChangeDatetime = contract.getContractChangeDatetime();
        this.communicationExpense = contract.getCommunicationExpense();
    }
}
