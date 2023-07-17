package com.udt.udt_dip.contract.adapter.out.persistence;

import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.contract.domain.model.Contractor;
import com.udt.udt_dip.contract.domain.model.InUseMobilePhone;
import com.udt.udt_dip.contract.domain.model.SubscriptionMobilePlan;
import com.udt.udt_dip.customer.adapter.out.persistence.entity.CustomerPersistenceEntity;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.entity.MobilePhonePersitenceEntity;
import com.udt.udt_dip.mobileplan.adapter.out.persistence.entity.MobilePlanPersistenceEntity;
import org.springframework.stereotype.Component;

@Component
public class ContractPersistenceMapper {

    public Contract fromPersistenceToDomain(ContractPersistenceEntity contractPersistenceEntity,
                                            CustomerPersistenceEntity customerPersistenceEntity,
                                            MobilePhonePersitenceEntity mobilePhonePersitenceEntity,
                                            MobilePlanPersistenceEntity mobilePlanPersistenceEntity) {

        return Contract.builder()
                .id(contractPersistenceEntity.getId())
                .phoneNumber(contractPersistenceEntity.getPhoneNumber())
                .firstContractDate(contractPersistenceEntity.getFirstContractDate())
                .contractor(Contractor.generate(contractPersistenceEntity.getCustomerId(),
                        customerPersistenceEntity.getName()))
                .inUseMobilePhone(InUseMobilePhone.generate(contractPersistenceEntity.getMobilePhoneId(),
                        mobilePhonePersitenceEntity.getModel(), mobilePhonePersitenceEntity.getName()))
                .subscriptionMobilePlan(SubscriptionMobilePlan.generate(contractPersistenceEntity.getMobilePlanId(),
                        mobilePlanPersistenceEntity.getName(), mobilePlanPersistenceEntity.getPrice()))
                .contractChangeDatetime(contractPersistenceEntity.getContractChangeDatetime())
                .communicationExpense(contractPersistenceEntity.getCommunicationExpense())
                .build();
    }

    public ContractPersistenceEntity fromDomainToPersistence(Contract contract) {

        return ContractPersistenceEntity.builder()
                .id(contract.getId())
                .phoneNumber(contract.getPhoneNumber())
                .firstContractDate(contract.getFirstContractDate())
                .customerId(contract.getContractor().getCustomerId())
                .mobilePhoneId(contract.getInUseMobilePhone().getMobilePhoneId())
                .mobilePlanId(contract.getSubscriptionMobilePlan().getMobilePlanId())
                .contractChangeDatetime(contract.getContractChangeDatetime())
                .communicationExpense(contract.getCommunicationExpense())
                .build();
    }
}
