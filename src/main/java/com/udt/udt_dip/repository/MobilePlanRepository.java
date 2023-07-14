package com.udt.udt_dip.repository;

import com.udt.udt_dip.domain.MobilePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlanRepository extends JpaRepository<MobilePlan, Long> {
}
