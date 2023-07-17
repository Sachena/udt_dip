package com.udt.udt_dip.mobileplan.adapter.out.persistence;

import com.udt.udt_dip.common.exception.NoMobilePlanException;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.repository.MobilePhonePersistenceRepository;
import com.udt.udt_dip.mobileplan.application.port.MobilePlanPort;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePlanPersistenceAdapter implements MobilePlanPort {

    private final MobilePhonePersistenceRepository mobilePhonePersistenceRepository;
    private final MobilePlanMapper mobilePlanMapper;

    @Override
    public MobilePlan findById(Long id) {

        return mobilePlanMapper.fromPersistenceToDomain(mobilePhonePersistenceRepository.findById(id)
                .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다.")));
    }
}
