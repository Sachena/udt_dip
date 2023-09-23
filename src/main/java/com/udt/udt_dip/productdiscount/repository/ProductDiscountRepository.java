package com.udt.udt_dip.productdiscount.repository;

import com.udt.udt_dip.productdiscount.domain.ProductDiscount;

import java.util.List;

public interface ProductDiscountRepository {

    List<ProductDiscount> retrieveAllByIdList(List<Long> idList);
}
