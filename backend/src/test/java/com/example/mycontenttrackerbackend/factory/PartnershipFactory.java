package com.example.mycontenttrackerbackend.factory;

import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;

public abstract class PartnershipFactory {

    public static String PARTNER_A_NAME = "Partner A";
    private static String PARTNER_B_NAME = "Partner B";
    private static long FEE = 500;

    public static PartnershipPo valid() {
        return PartnershipPo.builder()
                .partnerName(PARTNER_A_NAME)
                .fee(FEE)
                .build();
    }
}
