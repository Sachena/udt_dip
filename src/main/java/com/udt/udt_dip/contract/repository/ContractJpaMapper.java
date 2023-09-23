package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.contract.domain.ContractDiscount;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractJpaMapper {

    public Contract fromEntityToDomain(ContractJpaEntity contractPersistenceEntity,
        List<ContractDiscountJpaEntity> contractDiscountPersistenceEntityList) {

        return Contract.builder()
            .id(contractPersistenceEntity.getId())
            .phoneNumber(contractPersistenceEntity.getPhoneNumber())
            .firstContractDate(contractPersistenceEntity.getFirstContractDate())
            .customerId(contractPersistenceEntity.getCustomerId())
            .mobilePhoneId(contractPersistenceEntity.getMobilePhoneId())
            .mobilePlanId(contractPersistenceEntity.getMobilePlanId())
            .contractChangeDatetime(contractPersistenceEntity.getContractChangeDatetime())
            .contractDiscountList(
                this.fromEntityListToDomainList(contractDiscountPersistenceEntityList))
            .build();
    }

    public ContractJpaEntity fromDomainToEntity(Contract contract) {

        return ContractJpaEntity.builder()
            .id(contract.getId())
            .phoneNumber(contract.getPhoneNumber())
            .firstContractDate(contract.getFirstContractDate())
            .customerId(contract.getCustomerId())
            .mobilePhoneId(contract.getMobilePhoneId())
            .mobilePlanId(contract.getMobilePlanId())
            .contractChangeDatetime(contract.getContractChangeDatetime())
            .build();
    }

    public List<ContractDiscount> fromEntityListToDomainList(
        List<ContractDiscountJpaEntity> contractDiscountPersistenceEntityList) {

        List<ContractDiscount> contractDiscountList = new ArrayList<>();

        for (ContractDiscountJpaEntity contractDiscountEntity : contractDiscountPersistenceEntityList) {
            contractDiscountList.add(this.fromEntityToDomain(contractDiscountEntity));
        }

        return contractDiscountList;
    }

    public ContractDiscount fromEntityToDomain(
        ContractDiscountJpaEntity contractDiscountPersistenceEntity) {

        return ContractDiscount.builder()
            .id(contractDiscountPersistenceEntity.getId())
            .contractId(contractDiscountPersistenceEntity.getContractId())
            .mobilePhoneId(contractDiscountPersistenceEntity.getMobilePhoneId())
            .mobilePlanId(contractDiscountPersistenceEntity.getMobilePlanId())
            .productDiscountId(contractDiscountPersistenceEntity.getProductDiscountId())
            .build();
    }
}
