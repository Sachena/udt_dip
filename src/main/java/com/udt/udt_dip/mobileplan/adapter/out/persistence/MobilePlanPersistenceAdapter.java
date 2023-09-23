package com.udt.udt_dip.mobileplan.adapter.out.persistence;

import com.udt.udt_dip.common.exception.NoMobilePlanException;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.repository.MobilePhonePersistenceRepository;
import com.udt.udt_dip.mobileplan.adapter.out.persistence.repository.MobilePlanPersistenceRepository;
import com.udt.udt_dip.mobileplan.application.port.out.MobilePlanOutputPort;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePlanPersistenceAdapter implements MobilePlanOutputPort {

    private final MobilePlanPersistenceRepository mobilePlanPersistenceRepository;
    private final MobilePlanPersistenceMapper mobilePlanPersistenceMapper;

    @Override
    public MobilePlan retrieve(Long id) {

        return mobilePlanPersistenceMapper
            .fromPersistenceToDomain(mobilePlanPersistenceRepository.findById(id)
                .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다.")));
    }
}
