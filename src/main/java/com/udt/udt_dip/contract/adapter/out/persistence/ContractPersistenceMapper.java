package com.udt.udt_dip.contract.adapter.out.persistence;

import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractDiscountPersistenceEntity;
import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.contract.domain.model.ContractDiscount;
import com.udt.udt_dip.customer.adapter.out.persistence.entity.CustomerPersistenceEntity;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.entity.MobilePhonePersitenceEntity;
import com.udt.udt_dip.mobileplan.adapter.out.persistence.entity.MobilePlanPersistenceEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractPersistenceMapper {

    public Contract fromPersistenceToDomain(ContractPersistenceEntity contractPersistenceEntity,
        List<ContractDiscountPersistenceEntity> contractDiscountPersistenceEntityList) {

        return Contract.builder()
            .id(contractPersistenceEntity.getId())
            .phoneNumber(contractPersistenceEntity.getPhoneNumber())
            .firstContractDate(contractPersistenceEntity.getFirstContractDate())
            .customerId(contractPersistenceEntity.getCustomerId())
            .mobilePhoneId(contractPersistenceEntity.getMobilePhoneId())
            .mobilePlanId(contractPersistenceEntity.getMobilePlanId())
            .contractChangeDatetime(contractPersistenceEntity.getContractChangeDatetime())
            .contractDiscountList(
                this.fromPersistenceListToDomainList(contractDiscountPersistenceEntityList))
            .build();
    }

    public ContractPersistenceEntity fromDomainToPersistence(Contract contract) {

        return ContractPersistenceEntity.builder()
            .id(contract.getId())
            .phoneNumber(contract.getPhoneNumber())
            .firstContractDate(contract.getFirstContractDate())
            .customerId(contract.getCustomerId())
            .mobilePhoneId(contract.getMobilePhoneId())
            .mobilePlanId(contract.getMobilePlanId())
            .contractChangeDatetime(contract.getContractChangeDatetime())
            .build();
    }

    public List<ContractDiscount> fromPersistenceListToDomainList(
        List<ContractDiscountPersistenceEntity> contractDiscountPersistenceEntityList) {

        List<ContractDiscount> contractDiscountList = new ArrayList<>();

        for (ContractDiscountPersistenceEntity contractDiscountEntity : contractDiscountPersistenceEntityList) {
            contractDiscountList.add(this.fromPersistenceToDomain(contractDiscountEntity));
        }

        return contractDiscountList;
    }

    public ContractDiscount fromPersistenceToDomain(
        ContractDiscountPersistenceEntity contractDiscountPersistenceEntity) {

        return ContractDiscount.builder()
            .id(contractDiscountPersistenceEntity.getId())
            .contractId(contractDiscountPersistenceEntity.getContractId())
            .mobilePhoneId(contractDiscountPersistenceEntity.getMobilePhoneId())
            .mobilePlanId(contractDiscountPersistenceEntity.getMobilePlanId())
            .productDiscountId(contractDiscountPersistenceEntity.getProductDiscountId())
            .build();
    }
}
