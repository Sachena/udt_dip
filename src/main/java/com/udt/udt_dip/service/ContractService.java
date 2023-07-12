package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        // 변경할 계약 정보 가져오기
        Contract targetContract = contractRepository.findById(Long.valueOf(updateMobilePlanRequest.getTargetContractId())).orElse(null);

        // 계약에서 요금제 정보 변경
        targetContract.updateMobilePlan(updateMobilePlanRequest.getTargetMobilePlanId());

        // 최종 요금제 정보 변경
        targetContract.updateFinalCommunicationExpense(updateMobilePlanRequest.getTargetMobilePlanId());


    }

    public Contract retrieveContract(RetrieveContractRequest retrieveContractRequest) {
        return contractRepository.findById(Long.valueOf(retrieveContractRequest.getTargetContractId())).orElse(null);
    }
}
