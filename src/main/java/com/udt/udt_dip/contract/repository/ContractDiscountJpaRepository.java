package com.udt.udt_dip.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDiscountJpaRepository extends
    JpaRepository<ContractDiscountJpaEntity, Long> {

    List<ContractDiscountJpaEntity> findAllByContractId(Long id);
}
