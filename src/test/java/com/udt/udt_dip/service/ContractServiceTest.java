package com.udt.udt_dip.service;

import com.udt.udt_dip.common.exception.NoContractException;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractRequest;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractResponse;
import com.udt.udt_dip.contract.adapter.in.web.model.UpdateMobilePlanRequest;
import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
import com.udt.udt_dip.contract.adapter.out.persistence.repository.ContractPersistenceRepository;
import com.udt.udt_dip.contract.application.usecase.ContractService;
import com.udt.udt_dip.contract.domain.model.Contract;
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
    private ContractPersistenceRepository contractPersistenceRepository;

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
        ContractPersistenceEntity contract = contractPersistenceRepository.findById(1L)
            .orElseThrow(() -> new NoContractException("존재하지 않는 게약정보입니다."));

        assertEquals("1", String.valueOf(contract.getId()));
        assertEquals("2", String.valueOf(contract.getMobilePlanId()));

    }
}