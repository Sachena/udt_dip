package com.udt.udt_dip.contract.domain.model;

import com.udt.udt_dip.customer.domain.model.Customer;
import com.udt.udt_dip.mobilephone.domain.model.MobilePhone;
import com.udt.udt_dip.mobileplan.domain.model.MobilePlan;
import com.udt.udt_dip.productdiscount.domain.model.ProductDiscount;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Contract {

    private Long id;
    private String phoneNumber;
    private LocalDateTime firstContractDate;
    private Long customerId;
    private Long mobilePhoneId;
    private Long mobilePlanId;
    private LocalDateTime contractChangeDatetime;
    private List<ContractDiscount> contractDiscountList;

    public void updateInUseMobilePlan(Long mobilePhoneId) {
        if (ObjectUtils.equals(this.mobilePlanId, mobilePhoneId)) {
            throw new RuntimeException("동일한 요금제로의 변경은 불가합니다.");
        } else {
            this.mobilePlanId = mobilePhoneId;
        }
    }

    public float calculateContractBillAmount(MobilePlan mobilePlan, List<ProductDiscount> productDiscountList) {

        float contractBillAmount = mobilePlan.getPrice();
        float discountPrice = 0;

        for (ProductDiscount productDiscount : productDiscountList) {
            if ("price".equals(productDiscount.getType())) {
                discountPrice += productDiscount.getPrice();
            } else if ("ratio".equals(productDiscount.getType())) {
                discountPrice += mobilePlan.getPrice() * productDiscount.getRatio();
            }
        }
        contractBillAmount -= discountPrice;

        return contractBillAmount;
    }
}
