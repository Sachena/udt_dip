package com.udt.udt_dip.repository;

import com.udt.udt_dip.entity.ContractDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDiscountRepository extends JpaRepository<ContractDiscount, Long> {

    List<ContractDiscount> findAllByContractId(Long contractId);
}
