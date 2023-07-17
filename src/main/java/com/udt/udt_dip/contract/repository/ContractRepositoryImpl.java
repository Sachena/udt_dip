package com.udt.udt_dip.contract.repository;


import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.exception.NoContractException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractJpaMapper contractJpaMapper;
    private final ContractJpaRepository contractJpaRepository;


    @Override
    public Contract findById(String id) {
        return contractJpaMapper.fromEntityToDomain(
            contractJpaRepository.findById(NumberUtils.toLong(id))
                .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."))
        );
    }

    @Override
    public void insert(Contract contract) {
        contractJpaRepository.save(contractJpaMapper.fromDomainToEntity(contract));
    }

    @Override
    public void update(Contract contract) {
        ContractJpaEntity contractJpaEntity = contractJpaRepository.findById(NumberUtils.toLong(contract.getId()))
            .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        contractJpaEntity.update(contract);
    }
}
