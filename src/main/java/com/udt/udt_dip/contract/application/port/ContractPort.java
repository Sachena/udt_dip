package com.udt.udt_dip.contract.application.port;


import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.contract.domain.model.Contractor;

public interface ContractPort {

    Contract retrieve(Long id);

    void update(Contract contract);
}
