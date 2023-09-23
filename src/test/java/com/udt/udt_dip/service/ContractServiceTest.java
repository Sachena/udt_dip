package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.RetrieveContractResponse;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.exception.NoContractException;
import com.udt.udt_dip.repository.ContractRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractRepository contractRepository;

    @Test
    void retrieveContract() {

        //given
        RetrieveContractRequest retrieveContractRequest = new RetrieveContractRequest();
        retrieveContractRequest.setContractId("1");

        //when
        RetrieveContractResponse retrieveContractResponse = contractService
            .retrieveContract(retrieveContractRequest);

        //then
        assertEquals(retrieveContractResponse.getContractId(), "1");
        assertEquals(retrieveContractResponse.getCustomerName(), "테스터");
        assertEquals(retrieveContractResponse.getMobilePhoneName(), "갤럭시 Z 폴드3 512G");
        assertEquals(retrieveContractResponse.getContractBillAmount(), "63750.0");


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
        Contract contract = contractRepository.findById(1L)
            .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        assertEquals("1", String.valueOf(contract.getId()));
        assertEquals("2", String.valueOf(contract.getMobilePlanId()));

    }
}