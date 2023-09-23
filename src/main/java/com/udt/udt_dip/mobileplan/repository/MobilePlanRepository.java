package com.udt.udt_dip.mobileplan.repository;

import com.udt.udt_dip.mobileplan.domain.MobilePlan;

public interface MobilePlanRepository {

    MobilePlan findById(String id);
}
