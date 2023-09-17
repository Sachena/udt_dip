package com.udt.udt_dip.contract.application.port.in;

import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractRequest;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractResponse;
import com.udt.udt_dip.contract.adapter.in.web.model.UpdateMobilePlanRequest;

public interface ContractInputPort {

    RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest);

    void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest);
}
