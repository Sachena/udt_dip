package com.udt.udt_dip.mobilephone.application.port;

import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;

public interface MobilePhonePort {

    MobilePhone findById(Long id);
}
