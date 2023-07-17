package com.udt.udt_dip.customer.repository;

import com.udt.udt_dip.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerPersistenceMapper {

    public Customer fromEntityToDomain(CustomerJpaEntity customerJpaEntity) {
        return new Customer(
            customerJpaEntity.getId(),
            customerJpaEntity.getName(),
            customerJpaEntity.getResidentNumber()
        );
    }
}
