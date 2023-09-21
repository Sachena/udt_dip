package com.udt.udt_dip.mobileplandiscount.repository;

import com.udt.udt_dip.mobileplandiscount.domain.MobilePlanDiscount;

public interface MobilePlanDiscountRepository {
    MobilePlanDiscount findById(String id);
}
