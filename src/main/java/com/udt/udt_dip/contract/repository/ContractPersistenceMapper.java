package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
import org.springframework.stereotype.Component;

@Component
public class ContractPersistenceMapper {

    public Contract fromEntityToDomain(ContractJpaEntity contractJpaEntity) {
        return new Contract(
            contractJpaEntity.getId(),
            contractJpaEntity.getPhoneNumber(),
            contractJpaEntity.getFirstContractDate(),
            contractJpaEntity.getCustomerId(),
            contractJpaEntity.getMobilePhoneId(),
            contractJpaEntity.getMobilePlanId(),
            contractJpaEntity.getContractChangeDatetime(),
            contractJpaEntity.getCommunicationExpense()
        );
    }

    public ContractJpaEntity fromDomainToEntity(Contract contract) {
        return new ContractJpaEntity(
            contract.getId(),
            contract.getPhoneNumber(),
            contract.getFirstContractDate(),
            contract.getCustomerId(),
            contract.getMobilePhoneId(),
            contract.getMobilePlanId(),
            contract.getContractChangeDatetime(),
            contract.getCommunicationExpense()
        );
    }
}
