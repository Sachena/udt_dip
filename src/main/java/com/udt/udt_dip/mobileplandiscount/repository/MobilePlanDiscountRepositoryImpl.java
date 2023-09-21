package com.udt.udt_dip.mobileplandiscount.repository;

import com.udt.udt_dip.exception.NoMobilePlanException;
import com.udt.udt_dip.mobileplandiscount.domain.MobilePlanDiscount;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MobilePlanDiscountRepositoryImpl implements MobilePlanDiscountRepository{

    private final MobilePlanDiscountJpaMapper mobilePlanDiscountJpaMapper;

    private final MobilePlanDiscountJpaRepository mobilePlanDiscountJpaRepository;


    @Override
    public MobilePlanDiscount findById(String id) {
        List<MobilePlanDiscountJpaEntity> mobilePlanDiscountJpaEntities = mobilePlanDiscountJpaRepository.findAll();
        mobilePlanDiscountJpaEntities.forEach(mobilePlanDiscountJpaEntity -> {
            System.out.println(mobilePlanDiscountJpaEntity.getId());
            System.out.println(mobilePlanDiscountJpaEntity.getName());
        });

        return mobilePlanDiscountJpaMapper.fromEntityToDomain(
                mobilePlanDiscountJpaRepository.findById(NumberUtils.toLong(id))
                        .orElseThrow(() -> new NoMobilePlanException("존재하지 않는 요금제 할인 정보입니다."))
        );
    }

}
