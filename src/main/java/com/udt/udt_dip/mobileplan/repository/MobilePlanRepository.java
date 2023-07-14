package com.udt.udt_dip.mobileplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlanRepository extends JpaRepository<MobilePlan, Long> {
}
