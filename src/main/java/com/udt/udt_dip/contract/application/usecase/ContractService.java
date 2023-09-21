package com.udt.udt_dip.contract.application.usecase;

import com.udt.udt_dip.contract.application.port.in.ContractInputPort;
import com.udt.udt_dip.contract.application.port.out.ContractOutputPort;
import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractRequest;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractResponse;
import com.udt.udt_dip.contract.adapter.in.web.model.UpdateMobilePlanRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContractService implements ContractInputPort {

    private final ContractOutputPort contractOutputPort;

    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest) {

        Contract contract = contractOutputPort.retrieve(NumberUtils.toLong(retrieveContractRequest.getContractId()));

        return RetrieveContractResponse.generateByDomain(contract);
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        // 변경할 계약 정보 가져오기 (요금제 존재여부 검사)
        Contract contract = contractOutputPort.retrieve(NumberUtils.toLong(updateMobilePlanRequest.getTargetContractId()));

        // 계약에서 요금제 정보 변경
        contract.updateInUseMobilePlan(updateMobilePlanRequest.getTargetMobilePlanId());

        // 요금 계산
        String calculatedPrice = contract.getSubscriptionMobilePlan().calculatePrice();

        // 통신비 (최종 통신비) 변경
        contract.updateCommunicationExpense(calculatedPrice);

        contractOutputPort.update(contract);
    }
}
