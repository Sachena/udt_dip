package com.udt.udt_dip.contract.adapter.out.persistence.repository;

import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractPersistenceRepository extends JpaRepository<ContractPersistenceEntity, Long> {
}
