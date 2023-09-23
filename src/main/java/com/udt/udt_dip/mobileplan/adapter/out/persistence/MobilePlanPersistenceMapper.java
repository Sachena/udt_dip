package com.udt.udt_dip.mobileplan.adapter.out.persistence;

import com.udt.udt_dip.mobileplan.adapter.out.persistence.entity.MobilePlanPersistenceEntity;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import org.springframework.stereotype.Component;

@Component
public class MobilePlanPersistenceMapper {

    public MobilePlan fromPersistenceToDomain(
        MobilePlanPersistenceEntity mobilePlanPersitenceEntity) {
        return MobilePlan.builder()
            .id(mobilePlanPersitenceEntity.getId())
            .name(mobilePlanPersitenceEntity.getName())
            .description(mobilePlanPersitenceEntity.getDescription())
            .price(Integer.parseInt(mobilePlanPersitenceEntity.getPrice()))
            .build();
    }
}
