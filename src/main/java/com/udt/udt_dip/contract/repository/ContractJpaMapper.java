package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
public class ContractJpaMapper {

    public Contract fromEntityToDomain(ContractJpaEntity contractJpaEntity) {
        return new Contract(
            String.valueOf(contractJpaEntity.getId()),
            contractJpaEntity.getPhoneNumber(),
            contractJpaEntity.getFirstContractDate(),
            contractJpaEntity.getCustomerId(),
            contractJpaEntity.getMobilePhoneId(),
            contractJpaEntity.getMobilePlanId(),
            contractJpaEntity.getMobilePlanDiscountId(),
            contractJpaEntity.getContractChangeDatetime(),
            contractJpaEntity.getCommunicationExpense()
        );
    }

    public ContractJpaEntity fromDomainToEntity(Contract contract) {
        return new ContractJpaEntity(
            NumberUtils.toLong(contract.getId()),
            contract.getPhoneNumber(),
            contract.getFirstContractDate(),
            contract.getCustomerId(),
            contract.getMobilePhoneId(),
            contract.getMobilePlanId(),
            contract.getMobilePlanDiscountId(),
            contract.getContractChangeDatetime(),
            contract.getCommunicationExpense()
        );
    }
}
