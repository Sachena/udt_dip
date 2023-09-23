package com.udt.udt_dip.contract.adapter.out.persistence;

import com.udt.udt_dip.common.exception.NoContractException;
import com.udt.udt_dip.common.exception.NoCustomerException;
import com.udt.udt_dip.common.exception.NoMobilePhoneException;
import com.udt.udt_dip.common.exception.NoMobilePlanException;
import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractDiscountPersistenceEntity;
import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
import com.udt.udt_dip.contract.adapter.out.persistence.repository.ContractDiscountPersistenceRepository;
import com.udt.udt_dip.contract.adapter.out.persistence.repository.ContractPersistenceRepository;
import com.udt.udt_dip.contract.application.port.out.ContractOutputPort;
import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.customer.adapter.out.persistence.repository.CustomerPersistenceRepository;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.repository.MobilePhonePersistenceRepository;
import com.udt.udt_dip.mobileplan.adapter.out.persistence.repository.MobilePlanPersistenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContractPersistenceAdapter implements ContractOutputPort {

    private final ContractPersistenceMapper contractPersistenceMapper;
    private final ContractPersistenceRepository contractPersistenceRepository;
    private final ContractDiscountPersistenceRepository contractDiscountPersistenceRepository;

    @Override
    public Contract retrieve(Long id) {

        ContractPersistenceEntity contractPersistenceEntity = contractPersistenceRepository
            .findById(id)
            .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        List<ContractDiscountPersistenceEntity> contractDiscountPersistenceEntityList =
            contractDiscountPersistenceRepository
                .findAllByContractId(contractPersistenceEntity.getId());

        return contractPersistenceMapper.fromPersistenceToDomain(contractPersistenceEntity,
            contractDiscountPersistenceEntityList);
    }

    @Override
    public void update(Contract contract) {

        ContractPersistenceEntity contractPersistenceEntity = contractPersistenceRepository
            .findById(contract.getId())
            .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        contractPersistenceEntity.updateByDomain(contract);
    }

}
