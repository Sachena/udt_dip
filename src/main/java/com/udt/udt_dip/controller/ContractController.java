package com.udt.udt_dip.controller;


import com.udt.udt_dip.dto.RetrieveContractInUseMobilePlan;
import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.RetrieveContractResponse;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.service.ContractService;
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

    @GetMapping("/v1/contract/mobile/plan")
    public RetrieveContractInUseMobilePlan retrieveContractInUseMobilePlan(RetrieveContractRequest retrieveContractRequest){
        return contractService.retrieveContractInUseMobilePlan(retrieveContractRequest);
    }

    @PostMapping("/v1/contract")
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest){
        contractService.updateMobilePlan(updateMobilePlanRequest);
    }

}
