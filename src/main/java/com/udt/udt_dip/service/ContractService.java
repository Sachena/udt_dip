package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractInUseMobilePlan;
import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.RetrieveContractResponse;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.entity.*;
import com.udt.udt_dip.exception.NoContractException;
import com.udt.udt_dip.exception.NoCustomerException;
import com.udt.udt_dip.exception.NoMobilePhoneException;
import com.udt.udt_dip.exception.NoMobilePlanException;
import com.udt.udt_dip.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final MobilePhoneRepository mobilePhoneRepository;
    private final MobilePlanRepository mobilePlanRepository;
    private final ContractDiscountRepository contractDiscountRepository;
    private final ProductDiscountRepository productDiscountRepository;

    @Transactional(readOnly = true)
    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest) {

        try {
            Contract contract = contractRepository.findById(NumberUtils.toLong(retrieveContractRequest.getContractId()))
                    .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

            Customer customer = customerRepository.findById(contract.getCustomerId())
                    .orElseThrow(() -> new NoCustomerException("고객 정보가 존재하지 않습니다."));

            MobilePhone mobilePhone = mobilePhoneRepository.findById(contract.getMobilePhoneId())
                    .orElseThrow(() -> new NoMobilePhoneException("휴대폰 단말 정보가 존재하지 않습니다."));

            MobilePlan mobilePlan = mobilePlanRepository.findById(contract.getMobilePlanId())
                    .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다."));

            List<ContractDiscount> contractDiscountList = contractDiscountRepository.findAllByContractId(contract.getId());

            float contractBillAmount = mobilePlan.getPrice();
            if (!CollectionUtils.isEmpty(contractDiscountList)) {

                List<ProductDiscount> productDiscountList = productDiscountRepository.findAllById(contractDiscountList
                        .stream().map(ContractDiscount::getProductDiscountId).collect(Collectors.toList()));

                float discountPrice = 0;
                for (ProductDiscount productDiscount : productDiscountList) {
                    if ("price".equals(productDiscount.getType())) {
                        discountPrice += productDiscount.getPrice();
                    } else if ("ratio".equals(productDiscount.getType())) {
                        discountPrice += mobilePlan.getPrice() * productDiscount.getRatio();
                    }
                }
                contractBillAmount -= discountPrice;
            }

            return new RetrieveContractResponse(contract, customer, mobilePhone, mobilePlan, contractBillAmount);

        } catch (Exception e) {
            throw new RuntimeException("계약 정보를 확인할 수 없습니다.");
        }
    }

    @Transactional(readOnly = true)
    public RetrieveContractInUseMobilePlan retrieveContractInUseMobilePlan(RetrieveContractRequest retrieveContractRequest) {

        try {
            Contract contract = contractRepository.findById(NumberUtils.toLong(retrieveContractRequest.getContractId()))
                    .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

            Customer customer = customerRepository.findById(contract.getCustomerId())
                    .orElseThrow(() -> new NoCustomerException("고객 정보가 존재하지 않습니다."));

            MobilePlan mobilePlan = mobilePlanRepository.findById(contract.getMobilePlanId())
                    .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다."));

            return new RetrieveContractInUseMobilePlan(contract, customer, mobilePlan);

        } catch (Exception e) {
            throw new RuntimeException("사용중인 요금제 정보를 확인할 수 없습니다");
        }
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        try {
            // 변경할 계약 정보 가져오기
            Contract contract = contractRepository.findById(NumberUtils.toLong(updateMobilePlanRequest.getTargetContractId()))
                    .orElseThrow(() -> new NoContractException("존재하지 않는 계약 정보입니다."));

            // 요금제 존재여부 => 요금제 정보 조회
            MobilePlan mobilePlan = mobilePlanRepository.findById(NumberUtils.toLong(updateMobilePlanRequest.getTargetMobilePlanId()))
                    .orElseThrow(() -> new NoMobilePlanException("요금제 정보가 존재하지 않습니다."));

            if (ObjectUtils.equals(contract.getMobilePlanId(), mobilePlan.getId())) {
                throw new RuntimeException("동일한 요금제로의 변경은 불가합니다.");
            }

            // 계약에서 요금제 정보 변경
            contract.updateMobilePlan(String.valueOf(mobilePlan.getId()));

        } catch (Exception e) {
            throw new RuntimeException("요금제 변경을 실패했습니다.");
        }
    }
}
