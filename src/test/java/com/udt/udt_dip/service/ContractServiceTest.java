package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.domain.Contract;
import com.udt.udt_dip.repository.ContractRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
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
        retrieveContractRequest.setContractId("1");

        //when
        Contract targetContract = contractRepository.findById(NumberUtils.toLong(retrieveContractRequest.getContractId())).orElse(null);

        //then
        assertEquals(ObjectUtils.toString(targetContract.getId()), "1");
        assertEquals(ObjectUtils.toString(targetContract.getCustomerId()) , "1");


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
        Contract targetContract = contractRepository.findById(NumberUtils.toLong("1")).orElse(null);

        assertEquals(ObjectUtils.toString(targetContract.getId()), "1");
        assertEquals(ObjectUtils.toString(targetContract.getMobilePlanId()) , "2");
        System.out.println("targetContract.getCommunicationExpense() = " + targetContract.getCommunicationExpense());

    }
}