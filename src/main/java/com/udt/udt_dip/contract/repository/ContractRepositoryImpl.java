package com.udt.udt_dip.contract.repository;


import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.exception.NoContractException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractPersistenceMapper contractPersistenceMapper;
    private final ContractJpaRepository contractJpaRepository;


    @Override
    public Contract findById(String id) {
        return contractPersistenceMapper.fromEntityToDomain(
            contractJpaRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."))
        );
    }

    @Override
    public void save(Contract contract) {
        contractJpaRepository.save(contractPersistenceMapper.fromDomainToEntity(contract));
    }
}
