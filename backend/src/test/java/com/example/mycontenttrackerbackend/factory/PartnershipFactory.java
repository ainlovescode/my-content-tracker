package com.example.mycontenttrackerbackend.factory;

import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;

import java.util.UUID;

public abstract class PartnershipFactory {

    public static UUID PARTNERSHIP_ID = UUID.fromString("98028151-3051-45ed-aa73-e4ab2f7fbdf3");
    public static String PARTNER_A_NAME = "Partner A";
    public static String PARTNER_B_NAME = "Partner B";
    public static long PARTNERSHIP_FEE = 500;

    public static PartnershipPo valid() {
        return PartnershipPo.builder()
                .partnershipId(UUID.randomUUID())
                .partnerName(PARTNER_A_NAME)
                .partnershipFee(PARTNERSHIP_FEE)
                .build();
    }
}
