package com.udt.udt_dip.service;

import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.repository.ContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

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
    void retrieveContract(){
        List<Contract> contractList = contractRepository.findAll();
        contractList.forEach(contract -> {
            System.out.println("contract = " + contract);
        });
    }

    @Test
    void updateMobilePlan() {
    }
}