package com.udt.udt_dip.customer.repository;

import com.udt.udt_dip.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository {

    Customer findById(String id);

}
