package com.udt.udt_dip.productdiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountJpaRepository extends JpaRepository<ProductDiscountJpaEntity, Long> {
}
