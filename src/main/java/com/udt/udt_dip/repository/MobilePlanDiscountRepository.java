package com.udt.udt_dip.repository;

import com.udt.udt_dip.entity.MobilePlanDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlanDiscountRepository extends JpaRepository<MobilePlanDiscount, Long> {
}
