package com.udt.udt_dip.productdiscount.adapter.out;

import com.udt.udt_dip.productdiscount.adapter.out.entity.ProductDiscountPersistenceEntity;
import com.udt.udt_dip.productdiscount.domain.model.ProductDiscount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDiscountPersistenceMapper {

    public List<ProductDiscount> fromPersistenceListToDomainList(
        List<ProductDiscountPersistenceEntity> productDiscountPersistenceEntityList) {

        List<ProductDiscount> productDiscountList = new ArrayList<>();

        for (ProductDiscountPersistenceEntity entity : productDiscountPersistenceEntityList) {
            productDiscountList.add(this.fromPersistenceToDomain(entity));
        }

        return productDiscountList;
    }

    public ProductDiscount fromPersistenceToDomain(
        ProductDiscountPersistenceEntity productDiscountPersistenceEntity) {

        return ProductDiscount.builder()
            .id(productDiscountPersistenceEntity.getId())
            .mobilePhoneId(productDiscountPersistenceEntity.getMobilePhoneId())
            .mobilePlanId(productDiscountPersistenceEntity.getMobilePlanId())
            .type(productDiscountPersistenceEntity.getType())
            .name(productDiscountPersistenceEntity.getName())
            .price(productDiscountPersistenceEntity.getPrice())
            .ratio(productDiscountPersistenceEntity.getRatio())
            .description(productDiscountPersistenceEntity.getDescription())
            .build();
    }
}
