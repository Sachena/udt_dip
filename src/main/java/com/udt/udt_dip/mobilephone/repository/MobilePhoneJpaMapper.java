package com.udt.udt_dip.mobilephone.repository;

import com.udt.udt_dip.mobilephone.domain.MobilePhone;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobilePhoneJpaMapper {

    private final MobilePhoneJpaRepository mobilePhoneJpaRepository;


    public MobilePhone fromEntityToDomain(MobilePhoneJpaEntity mobilePhoneJpaEntity) {
        return new MobilePhone(

            String.valueOf(mobilePhoneJpaEntity.getId()),
            mobilePhoneJpaEntity.getManufacturer(),
            mobilePhoneJpaEntity.getModel(),
            mobilePhoneJpaEntity.getName(),
            mobilePhoneJpaEntity.getUsim(),
            mobilePhoneJpaEntity.getDescription(),
            mobilePhoneJpaEntity.getPrice()

        );
    }
}
