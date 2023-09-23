package com.udt.udt_dip.mobileplan.adapter.out.persistence.repository;

import com.udt.udt_dip.mobileplan.adapter.out.persistence.entity.MobilePlanPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePlanPersistenceRepository extends
    JpaRepository<MobilePlanPersistenceEntity, Long> {

}
