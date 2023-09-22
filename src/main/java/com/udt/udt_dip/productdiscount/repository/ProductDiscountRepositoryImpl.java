package com.udt.udt_dip.productdiscount.repository;

import com.udt.udt_dip.exception.NoMobilePlanException;
import com.udt.udt_dip.productdiscount.domain.ProductDiscount;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDiscountRepositoryImpl implements ProductDiscountRepository {

    private final ProductDiscountJpaMapper productDiscountJpaMapper;

    private final ProductDiscountJpaRepository productDiscountJpaRepository;


    @Override
    public List<ProductDiscount> retrieveAllByIdList(List<Long> idList) {

        return productDiscountJpaMapper.fromEntityListToDomainList(
                productDiscountJpaRepository.findAllById(idList));
    }

}
