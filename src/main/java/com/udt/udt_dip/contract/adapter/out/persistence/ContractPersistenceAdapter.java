package com.udt.udt_dip.contract.adapter.out.persistence;

import com.udt.udt_dip.common.exception.NoContractException;
import com.udt.udt_dip.common.exception.NoCustomerException;
import com.udt.udt_dip.common.exception.NoMobilePhoneException;
import com.udt.udt_dip.common.exception.NoMobilePlanException;
import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
import com.udt.udt_dip.contract.adapter.out.persistence.repository.ContractPersistenceRepository;
import com.udt.udt_dip.contract.application.port.ContractPort;
import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.customer.adapter.out.persistence.repository.CustomerPersistenceRepository;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.repository.MobilePhonePersistenceRepository;
import com.udt.udt_dip.mobileplan.adapter.out.persistence.repository.MobilePlanPersistenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractPersistenceAdapter implements ContractPort {

    private final ContractPersistenceMapper contractPersistenceMapper;
    private final ContractPersistenceRepository contractPersistenceRepository;
    private final CustomerPersistenceRepository customerPersistenceRepository;
    private final MobilePhonePersistenceRepository mobilePhonePersistenceRepository;
    private final MobilePlanPersistenceRepository mobilePlanPersistenceRepository;

    @Override
    public Contract retrieve(Long id) {
        ContractPersistenceEntity contractPersistenceEntity = contractPersistenceRepository.findById(id)
                .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        return contractPersistenceMapper.fromPersistenceToDomain(contractPersistenceEntity,
                customerPersistenceRepository.findById(contractPersistenceEntity.getCustomerId())
                        .orElseThrow(() -> new NoCustomerException("고객 정보가 존재하지 않습니다.")),
                mobilePhonePersistenceRepository.findById(contractPersistenceEntity.getMobilePhoneId())
                        .orElseThrow(() -> new NoMobilePhoneException("휴대폰 단말 정보가 존재하지 않습니다.")),
                mobilePlanPersistenceRepository.findById(contractPersistenceEntity.getMobilePlanId())
                        .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다."))
        );
    }

    @Override
    public void update(Contract contract) {

        ContractPersistenceEntity contractPersistenceEntity = contractPersistenceRepository.findById(contract.getId())
                .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        contractPersistenceEntity.updateByDomain(contract);
    }

}
