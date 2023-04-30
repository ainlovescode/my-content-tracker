package com.example.mycontenttrackerbackend.service.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Getter
public class PartnershipDto {

    private UUID partnershipId;

    private String partnerName;
    private long fee;
}
