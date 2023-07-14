package com.udt.udt_dip.mobilephone.repository;

import com.udt.udt_dip.exception.NoMobilePhoneException;
import com.udt.udt_dip.mobilephone.domain.MobilePhone;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePhoneRepositoryImpl implements MobilePhoneRepository{

    private final MobilePhoneMapper mobilePhoneMapper;
    private final MobilePhonePersistenceObjectRepository mobilePhonePersistenceObjectRepository;

    @Override
    public MobilePhone findById(String id) {
        return mobilePhoneMapper.fromEntityToDomain(mobilePhonePersistenceObjectRepository.findById(NumberUtils.toLong(id)).orElseThrow(()-> new NoMobilePhoneException("존재하지 않는 핸드폰정보 입니다.")));
    }
}
