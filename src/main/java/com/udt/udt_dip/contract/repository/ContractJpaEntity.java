package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
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

    private String mobilePlanDiscountId;

    private LocalDateTime contractChangeDatetime;

    private String communicationExpense;


    public void update(Contract contract) {
        this.phoneNumber=contract.getPhoneNumber();
        this.firstContractDate=contract.getFirstContractDate();
        this.customerId=contract.getCustomerId();
        this.mobilePhoneId=contract.getMobilePhoneId();
        this.mobilePlanId=contract.getMobilePlanId();
        this.contractChangeDatetime=LocalDateTime.now();
        this.communicationExpense=contract.getCommunicationExpense();

    }
}
