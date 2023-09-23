package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;

public interface ContractRepository {

    Contract findById(String id);

    void insert(Contract contract);

    void update(Contract contract);
}
