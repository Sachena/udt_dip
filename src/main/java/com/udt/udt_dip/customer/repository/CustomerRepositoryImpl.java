package com.udt.udt_dip.customer.repository;

import com.udt.udt_dip.customer.domain.Customer;
import com.udt.udt_dip.exception.NoCustomerException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaMapper customerJpaMapper;
    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public Customer findById(String id) {
        return customerJpaMapper.fromEntityToDomain(
            customerJpaRepository.findById(NumberUtils.toLong(id))
                .orElseThrow(() -> new NoCustomerException("존재하지 않는 고객입니다."))
        );
    }
}
