package com.udt.udt_dip.mobileplandiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlanDiscountJpaRepository extends JpaRepository<MobilePlanDiscountJpaEntity, Long> {
}
