package com.example.mycontenttrackerbackend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PartnershipDto {

    private UUID partnershipId;

    private String partnerName;
    private long partnershipFee;
}
