package com.udt.udt_dip.service;

import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.contract.dto.RetrieveContractResponse;
import com.udt.udt_dip.contract.service.ContractService;
import com.udt.udt_dip.contract.dto.RetrieveContractRequest;
import com.udt.udt_dip.mobileplan.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.contract.repository.ContractEntity;
import com.udt.udt_dip.contract.repository.ContractRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ContractEntityServiceTest {

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
        RetrieveContractResponse retrieveContractResponse = contractService.retrieveContract(retrieveContractRequest);

        //then
        assertEquals(retrieveContractResponse.getContractId(), "1");
        assertEquals(retrieveContractResponse.getCustomerName() , "테스터");
        assertEquals(retrieveContractResponse.getMobilePhoneName(),"갤럭시 Z 폴드3 512G");


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
        Contract contract = contractRepository.findById("1");

        assertEquals(ObjectUtils.toString(contract.getId()), "1");
        assertEquals(ObjectUtils.toString(contract.getMobilePlanId()) , "2");
        System.out.println("targetContract.getCommunicationExpense() = " + contract.getCommunicationExpense());

    }
}