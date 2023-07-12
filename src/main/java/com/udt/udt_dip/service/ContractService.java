package com.udt.udt_dip.service;

import com.udt.udt_dip.dto.RetrieveContractRequest;
import com.udt.udt_dip.dto.UpdateMobilePlanRequest;
import com.udt.udt_dip.entity.Contract;
import com.udt.udt_dip.entity.MobilePlan;
import com.udt.udt_dip.repository.ContractRepository;
import com.udt.udt_dip.repository.MobilePlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    private final MobilePlanRepository mobilePlanRepository;

    public Contract retrieveContract(RetrieveContractRequest retrieveContractRequest) {
        return contractRepository.findById(Long.valueOf(retrieveContractRequest.getTargetContractId())).orElseThrow(() -> new RuntimeException("존재하지 않는 계약 정보입니다."));
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        // 변경할 계약 정보 가져오기
        Contract targetContract = contractRepository.findById(Long.valueOf(updateMobilePlanRequest.getTargetContractId())).orElseThrow(() -> new RuntimeException("존재하지 않는 계약 정보입니다."));
        // 없으면, Throw Exception, error logging 후 이후 로직 수행, 없을때 로직을 별도로 정의해두고 해당 로직 수행 등등등 처리
        // 이러한 객체가 존재하지 않을때에 대한 다양한 처리를 지원하기 위해서 orElse*, if*, is* 등의 메소드가 있는 듯

        // 요금제 존재여부 => 요금제 정보 조회
        MobilePlan finalMobilePlan = mobilePlanRepository.findById(Long.valueOf(updateMobilePlanRequest.getTargetMobilePlanId())).orElseThrow(() -> new RuntimeException("존재하지 않는 요금제 정보입니다."));


        //할인 정보 조회 Discount targetDiscount = discountRepository.findById()
        //부가서비스 정보 조회 Additional targetAdditional = additionalRepository.findById()


        //요금제 계산 method 원래는 calculatePrice(finalMobilePlan.getPrice(), targetDiscount, targetAdditional)
        String finalPrice = calculatePrice(finalMobilePlan.getPrice());

        // 계약에서 요금제 정보 변경
        targetContract.updateMobilePlan(finalPrice);

        // 통신비 (최종 통신비) 변경
        targetContract.updateCommunicationExpense(finalMobilePlan.getPrice());
    }

    private String calculatePrice(String price){
        //String price = targetDiscount.calculatePrice(price);
        //price = targetAdditional.calculatePrice(price);

        return price;

    }


}
