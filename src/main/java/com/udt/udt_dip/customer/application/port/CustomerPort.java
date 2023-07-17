package com.udt.udt_dip.customer.application.port;

import com.udt.udt_dip.customer.domain.model.Customer;

public interface CustomerPort {

    Customer findById(Long id);
}
