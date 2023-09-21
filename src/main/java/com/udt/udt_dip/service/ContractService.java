package com.udt.udt_dip.service;

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
    private final BillRepository billRepository;
    private final BillDiscountRepository billDiscountRepository;

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

            RetrieveContractResponse retrieveContractResponse = new RetrieveContractResponse();
            retrieveContractResponse.setContractId(String.valueOf(contract.getId()));
            retrieveContractResponse.setPhoneNumber(contract.getPhoneNumber());
            retrieveContractResponse.setFirstContractDate(contract.getFirstContractDate());
            retrieveContractResponse.setContractChangeDatetime(contract.getContractChangeDatetime());
            retrieveContractResponse.setCommunicationExpense(String.valueOf(contract.getCommunicationExpense()));
            retrieveContractResponse.setCustomerName(customer.getName());
            retrieveContractResponse.setMobilePhoneModel(mobilePhone.getModel());
            retrieveContractResponse.setMobilePhoneName(mobilePhone.getName());
            retrieveContractResponse.setMobilePlanName(mobilePlan.getName());
            retrieveContractResponse.setMobilePlanPrice(String.valueOf(mobilePlan.getPrice()));

            return retrieveContractResponse;

        } catch (Exception e) {
            throw new RuntimeException("계약 정보를 확인할 수 없습니다.");
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

            List<BillDiscount> billDiscountList = billDiscountRepository.findAllById(updateMobilePlanRequest.getBillDiscountIdList()
                            .stream().map(NumberUtils::toLong).collect(Collectors.toList()));

            float discountPrice = 0;
            if (!CollectionUtils.isEmpty(billDiscountList)) {
                for (BillDiscount billDiscount : billDiscountList) {
                    if ("price".equals(billDiscount.getType())) {
                        discountPrice += billDiscount.getPrice();
                    } else if ("ratio".equals(billDiscount.getType())) {
                        discountPrice += mobilePlan.getPrice() * billDiscount.getRatio();
                    }
                }
            }

            // 요금 계산
            float calculatedPrice = mobilePlan.getPrice() - discountPrice;

            // 계약에서 요금제 정보 변경
            contract.updateMobilePlan(String.valueOf(mobilePlan.getId()));
            // 통신비 (최종 통신비) 변경
            contract.updateCommunicationExpense(calculatedPrice);

        } catch (Exception e) {
            throw new RuntimeException("요금제 변경을 실패했습니다.");
        }
    }
}
