package com.udt.udt_dip.productdiscount.adapter.out.repository;

import com.udt.udt_dip.productdiscount.adapter.out.entity.ProductDiscountPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDiscountPersistenceRepository extends JpaRepository<ProductDiscountPersistenceEntity, Long> {
}
