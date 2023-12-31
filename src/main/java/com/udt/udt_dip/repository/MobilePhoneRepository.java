package com.udt.udt_dip.repository;

import com.udt.udt_dip.domain.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long> {
}
