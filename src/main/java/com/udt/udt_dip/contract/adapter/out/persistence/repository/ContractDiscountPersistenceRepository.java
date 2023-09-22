package com.udt.udt_dip.contract.adapter.out.persistence.repository;

import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractDiscountPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDiscountPersistenceRepository extends JpaRepository<ContractDiscountPersistenceEntity, Long> {

    List<ContractDiscountPersistenceEntity> findAllByContractId(Long contractId);
}
