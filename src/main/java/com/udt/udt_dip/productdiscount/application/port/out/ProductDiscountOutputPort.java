package com.udt.udt_dip.productdiscount.application.port.out;

import com.udt.udt_dip.productdiscount.domain.model.ProductDiscount;

import java.util.List;

public interface ProductDiscountOutputPort {

    List<ProductDiscount> retrieveAllByIdList(List<Long> idList);
}
