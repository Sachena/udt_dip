package com.udt.udt_dip.customer.adapter.out.persistence.repository;

import com.udt.udt_dip.customer.adapter.out.persistence.entity.CustomerPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPersistenceRepository extends JpaRepository<CustomerPersistenceEntity, Long> {
}
