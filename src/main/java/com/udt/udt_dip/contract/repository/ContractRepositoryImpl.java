package com.udt.udt_dip.contract.repository;


import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.exception.NoContractException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractJpaMapper contractJpaMapper;
    private final ContractJpaRepository contractJpaRepository;
    private final ContractDiscountJpaRepository contractDiscountJpaRepository;


    @Override
    public Contract findById(String id) {
        ContractJpaEntity contractPersistenceEntity = contractJpaRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        List<ContractDiscountJpaEntity> contractDiscountPersistenceEntityList =
                contractDiscountJpaRepository.findAllByContractId(contractPersistenceEntity.getId());

        return contractJpaMapper.fromEntityToDomain(contractPersistenceEntity,
                contractDiscountPersistenceEntityList);
    }

    @Override
    public void insert(Contract contract) {
        contractJpaRepository.save(contractJpaMapper.fromDomainToEntity(contract));
    }

    @Override
    public void update(Contract contract) {
        ContractJpaEntity contractJpaEntity = contractJpaRepository.findById(contract.getId())
            .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        contractJpaEntity.update(contract);
    }
}
