package com.udt.udt_dip.controller;


import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping("/v1/contract")
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest){
        contractService.updateMobilePlan(updateMobilePlanRequest);
    }

}
