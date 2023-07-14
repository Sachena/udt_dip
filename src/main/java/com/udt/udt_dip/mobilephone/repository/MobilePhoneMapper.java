package com.udt.udt_dip.mobilephone.repository;

import com.udt.udt_dip.mobilephone.domain.MobilePhone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePhoneMapper {

    private final MobilePhonePersistenceObjectRepository mobilePhonePersistenceObjectRepository;


    public MobilePhone fromEntityToDomain(MobilePhoneEntity mobilePhoneEntity) {
        return new MobilePhone(

                mobilePhoneEntity.getId(),
                mobilePhoneEntity.getManufacturer(),
                mobilePhoneEntity.getModel(),
                mobilePhoneEntity.getName(),
                mobilePhoneEntity.getUsim(),
                mobilePhoneEntity.getDescription(),
                mobilePhoneEntity.getPrice()

        );
    }
}
