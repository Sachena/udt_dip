package com.udt.udt_dip.productdiscount.adapter.out;

import com.udt.udt_dip.productdiscount.adapter.out.repository.ProductDiscountPersistenceRepository;
import com.udt.udt_dip.productdiscount.application.port.out.ProductDiscountOutputPort;
import com.udt.udt_dip.productdiscount.domain.model.ProductDiscount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDiscountPersistenceAdapter implements ProductDiscountOutputPort {

    private final ProductDiscountPersistenceRepository productDiscountPersistenceRepository;
    private final ProductDiscountPersistenceMapper productDiscountPersistenceMapper;

    @Override
    public List<ProductDiscount> retrieveAllByIdList(List<Long> idList) {

        return productDiscountPersistenceMapper.fromPersistenceListToDomainList(
            productDiscountPersistenceRepository.findAllById(idList));
    }
}
