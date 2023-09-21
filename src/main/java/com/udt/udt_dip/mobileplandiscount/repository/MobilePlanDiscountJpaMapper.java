package com.udt.udt_dip.mobileplandiscount.repository;

import com.udt.udt_dip.mobileplandiscount.domain.MobilePlanDiscount;
import org.springframework.stereotype.Component;

@Component
public class MobilePlanDiscountJpaMapper {
    public MobilePlanDiscount fromEntityToDomain(MobilePlanDiscountJpaEntity mobilePlanDiscountJpaEntity) {
        return new MobilePlanDiscount(
                Long.valueOf(mobilePlanDiscountJpaEntity.getId()),
                Long.valueOf(mobilePlanDiscountJpaEntity.getMobilePlanId()),
                mobilePlanDiscountJpaEntity.getName(),
                Float.valueOf(mobilePlanDiscountJpaEntity.getRatio()),
                mobilePlanDiscountJpaEntity.getDescription()
        );
    }
}
