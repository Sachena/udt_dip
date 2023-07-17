package com.udt.udt_dip.mobilephone.repository;

import com.udt.udt_dip.mobilephone.domain.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MobilePhoneRepository {

    MobilePhone findById(String id);
}
