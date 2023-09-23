package com.udt.udt_dip.customer.adapter.out.persistence;

import com.udt.udt_dip.customer.adapter.out.persistence.entity.CustomerPersistenceEntity;
import com.udt.udt_dip.customer.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerPersistenceMapper {

    public Customer fromPersistenceToDomain(CustomerPersistenceEntity customerPersistenceEntity) {

        return Customer.builder()
            .id(customerPersistenceEntity.getId())
            .name(customerPersistenceEntity.getName())
            .residentNumber(customerPersistenceEntity.getResidentNumber())
            .build();
    }
}
