package com.udt.udt_dip.mobileplan.repository;

import com.udt.udt_dip.mobileplan.domain.MobilePlan;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
public class MobilePlanJpaMapper {

    public MobilePlan fromEntityToDomain(MobilePlanJpaEntity mobilePlanJpaEntity) {

        return new MobilePlan(
            String.valueOf(mobilePlanJpaEntity.getId()),
            mobilePlanJpaEntity.getName(),
            mobilePlanJpaEntity.getPrice(),
            mobilePlanJpaEntity.getDescription()
        );

    }
}
