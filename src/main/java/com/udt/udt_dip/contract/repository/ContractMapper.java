package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContractMapper {
    public Contract fromEntityToDomain(ContractEntity contractEntity) {
        return new Contract(
                contractEntity.getId(),
                contractEntity.getPhoneNumber(),
                contractEntity.getFirstContractDate(),
                contractEntity.getCustomerId(),
                contractEntity.getMobilePhoneId(),
                contractEntity.getMobilePlanId(),
                contractEntity.getContractChangeDatetime(),
                contractEntity.getCommunicationExpense()
        );
    }

    public ContractEntity fromDomainToEntity(Contract contract) {
        return new ContractEntity(
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
