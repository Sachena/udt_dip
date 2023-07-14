package com.udt.udt_dip.contract.repository;


import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.exception.NoContractException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractMapper contractMapper;
    private final ContractJpaRepository contractJpaRepository;



    @Override
    public Contract findById(String id) {
       return contractMapper.fromEntityToDomain(contractJpaRepository.findById(NumberUtils.toLong(id)).orElseThrow(()-> new NoContractException("존재하지 않는 계약 정보입니다.")));
    }

    @Override
    public void save(Contract contract) {
        contractMapper.fromDomainToEntity(contract);
    }
}
