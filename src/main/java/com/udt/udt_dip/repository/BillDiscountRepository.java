package com.udt.udt_dip.repository;

import com.udt.udt_dip.entity.BillDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDiscountRepository extends JpaRepository<BillDiscount, Long> {
}
