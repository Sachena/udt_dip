package com.udt.udt_dip.customer.adapter.out.persistence;

import com.udt.udt_dip.common.exception.NoCustomerException;
import com.udt.udt_dip.customer.adapter.out.persistence.repository.CustomerPersistenceRepository;
import com.udt.udt_dip.customer.application.port.CustomerPort;
import com.udt.udt_dip.customer.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements CustomerPort {

    private final CustomerPersistenceRepository customerPersistenceRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Customer findById(Long id) {
        return customerMapper.fromPersistenceToDomain(customerPersistenceRepository.findById(id)
                .orElseThrow(() -> new NoCustomerException("고객 정보가 존재하지 않습니다.")));
    }
}
