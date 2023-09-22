package com.udt.udt_dip.contract.service;

import com.udt.udt_dip.contract.domain.Contract;
import com.udt.udt_dip.contract.domain.ContractDiscount;
import com.udt.udt_dip.contract.dto.RetrieveContractInUseMobilePlan;
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
import com.udt.udt_dip.productdiscount.domain.ProductDiscount;
import com.udt.udt_dip.productdiscount.repository.ProductDiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final MobilePhoneRepository mobilePhoneRepository;
    private final MobilePlanRepository mobilePlanRepository;
    private final ProductDiscountRepository productDiscountRepository;

    @Transactional(readOnly = true)
    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest) {

        try{

            Contract contract = contractRepository.findById(retrieveContractRequest.getContractId());

            Customer customer = customerRepository.findById(String.valueOf(contract.getCustomerId()));

            MobilePhone mobilePhone = mobilePhoneRepository.findById(String.valueOf(contract.getMobilePhoneId()));

            MobilePlan mobilePlan = mobilePlanRepository.findById(String.valueOf(contract.getMobilePlanId()));

            List<ProductDiscount> productDiscountList = productDiscountRepository.retrieveAllByIdList(
                    contract.getContractDiscountList().stream().map(ContractDiscount::getId).collect(Collectors.toList()));

            return new RetrieveContractResponse(contract, customer, mobilePhone, mobilePlan,
                    String.valueOf(contract.calculateContractBillAmount(mobilePlan, productDiscountList)) );

        } catch (Exception e){
            throw new RuntimeException("계약 정보를 확인할 수 없습니다.");
        }

    }

    @Transactional(readOnly = true)
    public RetrieveContractInUseMobilePlan retrieveContractInUseMobilePlan(RetrieveContractRequest retrieveContractRequest) {

        try {

            Contract contract = contractRepository.findById(retrieveContractRequest.getContractId());
            Customer customer = customerRepository.findById(String.valueOf(contract.getCustomerId()));
            MobilePlan mobilePlan = mobilePlanRepository.findById(String.valueOf(contract.getMobilePlanId()));

            return new RetrieveContractInUseMobilePlan(contract, customer, mobilePlan);

        } catch (Exception e) {
            throw new RuntimeException("사용중인 요금제 정보를 확인할 수 없습니다");
        }
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        try {
            // 변경할 계약 정보 가져오기 (요금제 존재여부 검사)
            Contract contract = contractRepository.findById(updateMobilePlanRequest.getContractId());

            MobilePlan mobilePlan = mobilePlanRepository.findById(String.valueOf(updateMobilePlanRequest.getMobilePlanId()));

            // 계약에서 요금제 정보 변경
            contract.updateInUseMobilePlan(mobilePlan.getId());
            contractRepository.update(contract);

        } catch (Exception e) {
            throw new RuntimeException("요금제 변경을 실패했습니다.");
        }
    }
}
