package com.udt.udt_dip.mobileplan.adapter.out.persistence;

import com.udt.udt_dip.mobilephone.adapter.out.persistence.entity.MobilePhonePersitenceEntity;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import org.springframework.stereotype.Component;

@Component
public class MobilePlanPersistenceMapper {

    public MobilePlan fromPersistenceToDomain(MobilePhonePersitenceEntity mobilePhonePersitenceEntity) {
        return MobilePlan.builder()
                .id(mobilePhonePersitenceEntity.getId())
                .name(mobilePhonePersitenceEntity.getName())
                .description(mobilePhonePersitenceEntity.getDescription())
                .price(mobilePhonePersitenceEntity.getPrice())
                .build();
    }
}
