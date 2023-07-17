package com.udt.udt_dip.mobilephone.adapter.out.persistence;

import com.udt.udt_dip.common.exception.NoMobilePhoneException;
import com.udt.udt_dip.mobilephone.adapter.out.persistence.repository.MobilePhonePersistenceRepository;
import com.udt.udt_dip.mobilephone.application.port.MobilePhonePort;
import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePhonePersistenceAdapter implements MobilePhonePort {

    private final MobilePhonePersistenceRepository mobilePhonePersistenceRepository;
    private final MobilePhonePersistenceMapper mobilePhonePersistenceMapper;

    @Override
    public MobilePhone findById(Long id) {

        return mobilePhonePersistenceMapper.fromPersistenceToDomain(mobilePhonePersistenceRepository.findById(id)
                .orElseThrow(() -> new NoMobilePhoneException("휴대폰 단말 정보가 존재하지 않습니다.")));
    }
}
