package com.udt.udt_dip.mobilephone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePhoneJpaRepository extends JpaRepository<MobilePhoneJpaEntity, Long> {

}
