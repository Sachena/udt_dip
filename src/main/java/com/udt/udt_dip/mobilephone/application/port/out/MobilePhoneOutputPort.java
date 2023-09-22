package com.udt.udt_dip.mobilephone.application.port.out;

import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;

public interface MobilePhoneOutputPort {

    MobilePhone retrieve(Long id);
}
