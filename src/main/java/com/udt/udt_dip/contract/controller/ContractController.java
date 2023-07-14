package com.udt.udt_dip.contract.controller;


import com.udt.udt_dip.contract.dto.RetrieveContractRequest;
import com.udt.udt_dip.contract.dto.RetrieveContractResponse;
import com.udt.udt_dip.mobileplan.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.contract.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping("/v1/contract")
    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest){
        return contractService.retrieveContract(retrieveContractRequest);
    }

    @PostMapping("/v1/contract")
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest){
        contractService.updateMobilePlan(updateMobilePlanRequest);
    }

}
