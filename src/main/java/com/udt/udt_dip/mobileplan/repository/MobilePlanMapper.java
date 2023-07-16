package com.udt.udt_dip.mobileplan.repository;

import com.udt.udt_dip.mobileplan.domain.MobilePlan;
import org.springframework.stereotype.Component;

@Component
public class MobilePlanMapper {
    public MobilePlan fromEntityToDomain(MobilePlanEntity mobilePlanEntity) {

        return new MobilePlan(
                mobilePlanEntity.getId(),
                mobilePlanEntity.getName(),
                mobilePlanEntity.getPrice(),
                mobilePlanEntity.getDescription()
        );

    }
}
