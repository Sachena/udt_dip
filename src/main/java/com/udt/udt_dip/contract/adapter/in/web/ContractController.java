package com.udt.udt_dip.contract.adapter.in.web;


import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractRequest;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractResponse;
import com.udt.udt_dip.contract.adapter.in.web.model.UpdateMobilePlanRequest;
import com.udt.udt_dip.contract.application.port.in.ContractInputPort;
import com.udt.udt_dip.contract.application.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractInputPort contractInputPort;

    @GetMapping("/v1/contract")
    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest){
        return contractInputPort.retrieveContract(retrieveContractRequest);
    }

    @PostMapping("/v1/contract")
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest){
        contractInputPort.updateMobilePlan(updateMobilePlanRequest);
    }

}
