package com.udt.udt_dip.mobileplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlanPersistenceObjectRepository extends JpaRepository<MobilePlanEntity, Long> {
}
