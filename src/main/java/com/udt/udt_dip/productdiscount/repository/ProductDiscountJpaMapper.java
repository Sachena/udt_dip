package com.udt.udt_dip.productdiscount.repository;

import com.udt.udt_dip.productdiscount.domain.ProductDiscount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDiscountJpaMapper {
    public List<ProductDiscount> fromEntityListToDomainList(List<ProductDiscountJpaEntity> productDiscountJpaEntityList) {

        List<ProductDiscount> productDiscountList = new ArrayList<>();

        for (ProductDiscountJpaEntity entity : productDiscountJpaEntityList) {
            productDiscountList.add(this.fromEntityToDomain(entity));
        }

        return productDiscountList;
    }

    public ProductDiscount fromEntityToDomain(ProductDiscountJpaEntity productDiscountJpaEntity) {

        return ProductDiscount.builder()
                .id(productDiscountJpaEntity.getId())
                .mobilePhoneId(productDiscountJpaEntity.getMobilePhoneId())
                .mobilePlanId(productDiscountJpaEntity.getMobilePlanId())
                .type(productDiscountJpaEntity.getType())
                .name(productDiscountJpaEntity.getName())
                .price(productDiscountJpaEntity.getPrice())
                .ratio(productDiscountJpaEntity.getRatio())
                .description(productDiscountJpaEntity.getDescription())
                .build();
    }
}
