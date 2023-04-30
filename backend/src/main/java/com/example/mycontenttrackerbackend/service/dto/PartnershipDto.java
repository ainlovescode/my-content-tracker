package com.example.mycontenttrackerbackend.service.dto;

import lombok.Getter;

import java.util.UUID;


@Getter
public class PartnershipDto {

    private UUID partnershipId;

    private String partnerName;
    private long fee;
}
