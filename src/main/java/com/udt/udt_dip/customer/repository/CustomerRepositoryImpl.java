package com.udt.udt_dip.customer.repository;

import com.udt.udt_dip.customer.domain.Customer;
import com.udt.udt_dip.exception.NoCustomerException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerMapper customerMapper;
    private final CustomerPersistenceObjectRepository customerPersistenceObjectRepository;

    @Override
    public Customer findById(String id) {
        return customerMapper.fromEntityToDomain(customerPersistenceObjectRepository.findById(NumberUtils.toLong(id)).orElseThrow(()-> new NoCustomerException("존재하지 않는 고객입니다.")));
    }
}
