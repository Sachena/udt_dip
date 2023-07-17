package com.udt.udt_dip.mobileplan.application.port;

import com.udt.udt_dip.mobileplan.adapter.out.persistence.entity.MobilePlanPersistenceEntity;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;

public interface MobilePlanPort {

    MobilePlan findById(Long id);
}
