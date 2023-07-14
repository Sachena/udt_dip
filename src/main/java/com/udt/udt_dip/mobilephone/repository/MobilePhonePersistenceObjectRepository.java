package com.udt.udt_dip.mobilephone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePhonePersistenceObjectRepository extends JpaRepository<MobilePhoneEntity, Long> {
}
