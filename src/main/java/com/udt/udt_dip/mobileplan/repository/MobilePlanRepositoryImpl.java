package com.udt.udt_dip.mobileplan.repository;

import com.udt.udt_dip.exception.NoMobilePlanException;
import com.udt.udt_dip.mobileplan.domain.MobilePlan;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePlanRepositoryImpl implements MobilePlanRepository {

    private final MobilePlanJpaMapper mobilePlanJpaMapper;

    private final MobilePlanJpaRepository mobilePlanJpaRepository;


    @Override
    public MobilePlan findById(String id) {
        return mobilePlanJpaMapper.fromEntityToDomain(
            mobilePlanJpaRepository.findById(NumberUtils.toLong(id))
                .orElseThrow(() -> new NoMobilePlanException("존재하지 않는 요금제 정보입니다."))
        );
    }
}
