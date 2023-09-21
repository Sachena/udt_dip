package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.RetrieveContractResponse;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.entity.Customer;
import com.udt.udt_dip.entity.MobilePhone;
import com.udt.udt_dip.entity.MobilePlan;
import com.udt.udt_dip.exception.NoContractException;
import com.udt.udt_dip.exception.NoCustomerException;
import com.udt.udt_dip.exception.NoMobilePhoneException;
import com.udt.udt_dip.exception.NoMobilePlanException;
import com.udt.udt_dip.repository.ContractRepository;
import com.udt.udt_dip.repository.CustomerRepository;
import com.udt.udt_dip.repository.MobilePhoneRepository;
import com.udt.udt_dip.repository.MobilePlanRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
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

        Contract contract = contractRepository.findById(NumberUtils.toLong(retrieveContractRequest.getContractId()))
                .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

        Customer customer = customerRepository.findById(contract.getCustomerId())
                .orElseThrow(() -> new NoCustomerException("고객 정보가 존재하지 않습니다."));

        MobilePhone mobilePhone = mobilePhoneRepository.findById(contract.getMobilePhoneId())
                .orElseThrow(() -> new NoMobilePhoneException("휴대폰 단말 정보가 존재하지 않습니다."));

        MobilePlan mobilePlan = mobilePlanRepository.findById(contract.getMobilePlanId())
                .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다."));

        RetrieveContractResponse retrieveContractResponse = new RetrieveContractResponse();
        retrieveContractResponse.setContractId(ObjectUtils.toString(contract.getId()));
        retrieveContractResponse.setPhoneNumber(contract.getPhoneNumber());
        retrieveContractResponse.setFirstContractDate(contract.getFirstContractDate());
        retrieveContractResponse.setContractChangeDatetime(contract.getContractChangeDatetime());
        retrieveContractResponse.setCommunicationExpense(contract.getCommunicationExpense());
        retrieveContractResponse.setCustomerName(customer.getName());
        retrieveContractResponse.setMobilePhoneModel(mobilePhone.getModel());
        retrieveContractResponse.setMobilePhoneName(mobilePhone.getName());
        retrieveContractResponse.setMobilePlanName(mobilePlan.getName());
        retrieveContractResponse.setMobilePlanPrice(mobilePlan.getPrice());

        return retrieveContractResponse;
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        // 변경할 계약 정보 가져오기
        Contract contract = contractRepository.findById(NumberUtils.toLong(updateMobilePlanRequest.getTargetContractId()))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 계약 정보입니다."));

        // 요금제 존재여부 => 요금제 정보 조회
        MobilePlan mobilePlan = mobilePlanRepository.findById(NumberUtils.toLong(updateMobilePlanRequest.getTargetMobilePlanId()))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 요금제 정보입니다."));

        // 계약에서 요금제 정보 변경
        contract.updateMobilePlan(ObjectUtils.toString(mobilePlan.getId()));

        // 요금제 계산
        String calculatedPrice = mobilePlan.calculatePrice();

        // 통신비 (최종 통신비) 변경
        contract.updateCommunicationExpense(calculatedPrice);

    }
}
