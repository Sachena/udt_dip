package com.udt.udt_dip.mobileplan.repository;

import com.udt.udt_dip.mobileplan.domain.MobilePlan;
import org.springframework.stereotype.Component;

@Component
public class MobilePlanPersistenceMapper {

    public MobilePlan fromEntityToDomain(MobilePlanJpaEntity mobilePlanJpaEntity) {

        return new MobilePlan(
            mobilePlanJpaEntity.getId(),
            mobilePlanJpaEntity.getName(),
            mobilePlanJpaEntity.getPrice(),
            mobilePlanJpaEntity.getDescription()
        );

    }
}
