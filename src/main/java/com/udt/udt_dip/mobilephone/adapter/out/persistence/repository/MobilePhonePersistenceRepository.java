package com.udt.udt_dip.mobilephone.adapter.out.persistence.repository;

import com.udt.udt_dip.mobilephone.adapter.out.persistence.entity.MobilePhonePersitenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePhonePersistenceRepository extends
    JpaRepository<MobilePhonePersitenceEntity, Long> {

}
