package com.udt.udt_dip.mobilephone.adapter.out.persistence;

import com.udt.udt_dip.mobilephone.adapter.out.persistence.entity.MobilePhonePersitenceEntity;
import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;
import org.springframework.stereotype.Component;

@Component
public class MobilePhoneMapper {

    public MobilePhone fromPersistenceToDomain(MobilePhonePersitenceEntity mobilePhonePersitenceEntity) {

        return MobilePhone.builder()
                .id(mobilePhonePersitenceEntity.getId())
                .manufacturer(mobilePhonePersitenceEntity.getManufacturer())
                .model(mobilePhonePersitenceEntity.getModel())
                .name(mobilePhonePersitenceEntity.getName())
                .usim(mobilePhonePersitenceEntity.getUsim())
                .description(mobilePhonePersitenceEntity.getDescription())
                .price(mobilePhonePersitenceEntity.getPrice())
                .build();
    }
}
