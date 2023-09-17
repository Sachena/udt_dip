package com.udt.udt_dip.customer.application.port.out;

import com.udt.udt_dip.customer.domain.model.Customer;

public interface CustomerOutputPort {

    Customer findById(Long id);
}
