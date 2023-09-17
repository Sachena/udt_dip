package com.udt.udt_dip.mobileplan.application.port.out;

import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;

public interface MobilePlanOutputPort {

    MobilePlan findById(Long id);
}
