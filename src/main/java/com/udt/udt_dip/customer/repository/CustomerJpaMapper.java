package com.udt.udt_dip.customer.repository;

import com.udt.udt_dip.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerJpaMapper {

    public Customer fromEntityToDomain(CustomerJpaEntity customerJpaEntity) {
        return new Customer(
            String.valueOf(customerJpaEntity.getId()),
            customerJpaEntity.getName(),
            customerJpaEntity.getResidentNumber()
        );
    }
}
