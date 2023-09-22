//package com.udt.udt_dip.service;
//
//import com.udt.udt_dip.contract.application.service.ContractService;
//import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractRequest;
//import com.udt.udt_dip.contract.adapter.in.web.model.UpdateMobilePlanRequest;
//import com.udt.udt_dip.contract.adapter.out.persistence.entity.ContractPersistenceEntity;
//import com.udt.udt_dip.contract.adapter.out.persistence.repository.ContractPersistenceRepository;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class ContractServiceTest {
//
//    @Autowired
//    private ContractService contractService;
//
//    @Autowired
//    private ContractPersistenceRepository contractPersistenceRepository;
//
//    @Test
//    void retrieveContract(){
//
//        //given
//        RetrieveContractRequest retrieveContractRequest = new RetrieveContractRequest();
//        retrieveContractRequest.setContractId("1");
//
//        //when
//        ContractPersistenceEntity targetContractPersistenceEntity = contractPersistenceRepository.findById(NumberUtils.toLong(retrieveContractRequest.getContractId())).orElseThrow();
//
//        //then
//        assertEquals(String.valueOf(targetContractPersistenceEntity.getId()), "1");
//        assertEquals(String.valueOf(targetContractPersistenceEntity.getCustomerId()) , "1");
//
//
//    }
//
//    @Test
//    void updateMobilePlan() {
//
//        //given
//        UpdateMobilePlanRequest updateMobilePlanRequest = new UpdateMobilePlanRequest();
//        updateMobilePlanRequest.setTargetContractId("1");
//        updateMobilePlanRequest.setTargetMobilePlanId("2");
//
//
//        //when
//        contractService.updateMobilePlan(updateMobilePlanRequest);
//
//        //then
//        ContractPersistenceEntity targetContractPersistenceEntity = contractPersistenceRepository.findById(NumberUtils.toLong("1")).orElseThrow();
//
//        assertEquals(String.valueOf(targetContractPersistenceEntity.getId()), "1");
//        assertEquals(String.valueOf(targetContractPersistenceEntity.getMobilePlanId()) , "2");
//    }
//}