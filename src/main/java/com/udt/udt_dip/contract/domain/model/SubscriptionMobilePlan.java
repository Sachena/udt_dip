package com.udt.udt_dip.contract.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class SubscriptionMobilePlan {

    private Long mobilePlanId;
    private String name;
    private String price;

    public static SubscriptionMobilePlan generate(Long id, String name, String price) {
        return SubscriptionMobilePlan.builder().mobilePlanId(id).name(name).price(price).build();
    }

    public void update(Long mobilePlanId) {
        this.mobilePlanId = mobilePlanId;
    }

    public String calculatePrice() {
        return this.getPrice();
    }
}
