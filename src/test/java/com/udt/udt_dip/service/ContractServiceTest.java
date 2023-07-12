package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.repository.ContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ContractServiceTest {

    @Autowired
    private ContractService contractService;
    
    @Autowired
    private ContractRepository contractRepository;
    
    @Test
    void retrieveContract(){

        //given
        RetrieveContractRequest retrieveContractRequest = new RetrieveContractRequest();
        retrieveContractRequest.setTargetContractId("1");

        //when
        Contract targetContract = contractRepository.findById(Long.valueOf(retrieveContractRequest.getTargetContractId())).orElse(null);

        //then
        assertEquals(String.valueOf(targetContract.getId()), "1");
        assertEquals(String.valueOf(targetContract.getCustomerId()) , "1");


    }

    @Test
    void updateMobilePlan() {

        //given
        UpdateMobilePlanRequest updateMobilePlanRequest = new UpdateMobilePlanRequest();
        updateMobilePlanRequest.setTargetContractId("1");
        updateMobilePlanRequest.setTargetMobilePlanId("2");


        //when
        contractService.updateMobilePlan(updateMobilePlanRequest);

        //then
        Contract targetContract = contractRepository.findById(Long.valueOf(1)).orElse(null);

        assertEquals(String.valueOf(targetContract.getId()), "1");
        assertEquals(String.valueOf(targetContract.getMobilePlanId()) , "2");
        System.out.println("targetContract.getCommunicationExpense() = " + targetContract.getCommunicationExpense());

    }
}