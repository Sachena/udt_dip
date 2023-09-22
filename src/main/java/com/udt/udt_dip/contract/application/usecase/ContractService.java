package com.udt.udt_dip.contract.application.usecase;

import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractInUseMobilePlan;
import com.udt.udt_dip.contract.application.port.in.ContractInputPort;
import com.udt.udt_dip.contract.application.port.out.ContractOutputPort;
import com.udt.udt_dip.contract.domain.model.Contract;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractRequest;
import com.udt.udt_dip.contract.adapter.in.web.model.RetrieveContractResponse;
import com.udt.udt_dip.contract.adapter.in.web.model.UpdateMobilePlanRequest;
import com.udt.udt_dip.contract.domain.model.ContractDiscount;
import com.udt.udt_dip.customer.application.port.out.CustomerOutputPort;
import com.udt.udt_dip.customer.domain.model.Customer;
import com.udt.udt_dip.mobilephone.application.port.out.MobilePhoneOutputPort;
import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;
import com.udt.udt_dip.mobileplan.application.port.out.MobilePlanOutputPort;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import com.udt.udt_dip.productdiscount.application.port.out.ProductDiscountOutputPort;
import com.udt.udt_dip.productdiscount.domain.model.ProductDiscount;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ContractService implements ContractInputPort {

    private final ContractOutputPort contractOutputPort;
    private final CustomerOutputPort customerOutputPort;
    private final MobilePhoneOutputPort mobilePhoneOutputPort;
    private final MobilePlanOutputPort mobilePlanOutputPort;
    private final ProductDiscountOutputPort productDiscountOutputPort;

    @Transactional(readOnly = true)
    public RetrieveContractResponse retrieveContract(RetrieveContractRequest retrieveContractRequest) {

        try {

            Contract contract = contractOutputPort.retrieve(NumberUtils.toLong(retrieveContractRequest.getContractId()));
            Customer customer = customerOutputPort.retrieve(contract.getCustomerId());
            MobilePhone mobilePhone = mobilePhoneOutputPort.retrieve(contract.getMobilePhoneId());
            MobilePlan mobilePlan = mobilePlanOutputPort.retrieve(contract.getMobilePlanId());
            List<ProductDiscount> productDiscountList = productDiscountOutputPort.retrieveAllByIdList(
                    contract.getContractDiscountList().stream().map(ContractDiscount::getId).collect(Collectors.toList()));

            return new RetrieveContractResponse(contract, customer, mobilePhone, mobilePlan,
                    contract.calculateContractBillAmount(mobilePlan, productDiscountList));

        } catch (Exception e) {
            throw new RuntimeException("계약 정보를 확인할 수 없습니다.");
        }
    }

    @Transactional(readOnly = true)
    public RetrieveContractInUseMobilePlan retrieveContractInUseMobilePlan(RetrieveContractRequest retrieveContractRequest) {

        try {

            Contract contract = contractOutputPort.retrieve(NumberUtils.toLong(retrieveContractRequest.getContractId()));
            Customer customer = customerOutputPort.retrieve(contract.getCustomerId());
            MobilePlan mobilePlan = mobilePlanOutputPort.retrieve(contract.getMobilePlanId());

            return new RetrieveContractInUseMobilePlan(contract, customer, mobilePlan);

        } catch (Exception e) {
            throw new RuntimeException("사용중인 요금제 정보를 확인할 수 없습니다");
        }
    }

    @Transactional
    public void updateMobilePlan(UpdateMobilePlanRequest updateMobilePlanRequest) {

        try {

            // 변경할 계약 정보 가져오기 (요금제 존재여부 검사)
            Contract contract = contractOutputPort.retrieve(NumberUtils.toLong(updateMobilePlanRequest.getTargetContractId()));
            MobilePlan mobilePlan = mobilePlanOutputPort.retrieve(NumberUtils.toLong(updateMobilePlanRequest.getTargetMobilePlanId()));

            // 계약에서 요금제 정보 변경
            contract.updateInUseMobilePlan(mobilePlan.getId());
            contractOutputPort.update(contract);

        } catch (Exception e) {
            throw new RuntimeException("요금제 변경을 실패했습니다.");
        }
    }
}
