package com.udt.udt_dip.contract.service;

import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.contract.dto.RetrieveContractRequest;
import com.udt.udt_dip.contract.dto.RetrieveContractResponse;
import com.udt.udt_dip.customer.domain.Customer;
import com.udt.udt_dip.mobilephone.domain.MobilePhone;
import com.udt.udt_dip.mobileplan.domain.MobilePlan;
import com.udt.udt_dip.contract.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.contract.repository.ContractRepository;
import com.udt.udt_dip.customer.repository.CustomerRepository;
import com.udt.udt_dip.mobilephone.repository.MobilePhoneRepository;
import com.udt.udt_dip.mobileplan.repository.MobilePlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final MobilePhoneRepository mobilePhoneRepository;
    private final MobilePlanRepository mobilePlanRepository;

    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest) {

        Contract contract = contractRepository.findById(retrieveContractRequest.getContractId());

        Customer customer = customerRepository.findById(contract.getCustomerId());

        MobilePhone mobilePhone = mobilePhoneRepository.findById(contract.getMobilePhoneId());

        MobilePlan mobilePlan = mobilePlanRepository.findById(contract.getMobilePlanId());

        return RetrieveContractResponse.generateResponseByDomain(contract, customer, mobilePhone, mobilePlan);
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        // 변경할 계약 정보 가져오기
        Contract contract = contractRepository.findById(updateMobilePlanRequest.getTargetContractId());

        // 요금제 존재여부 => 요금제 정보 조회
        MobilePlan mobilePlan = mobilePlanRepository.findById(contract.getMobilePlanId());

        // 계약에서 요금제 정보 변경
        contract.updateMobilePlan(updateMobilePlanRequest.getTargetMobilePlanId());

        // 요금제 계산
        String calculatedPrice = mobilePlan.calculatePrice();

        // 통신비 (최종 통신비) 변경
        contract.updateCommunicationExpense(calculatedPrice);

        contractRepository.save(contract);
    }
}
