package com.udt.udt_dip.contract.application.port.out;


import com.udt.udt_dip.contract.domain.model.Contract;

public interface ContractOutputPort {

    Contract retrieve(Long id);

    void update(Contract contract);
}
