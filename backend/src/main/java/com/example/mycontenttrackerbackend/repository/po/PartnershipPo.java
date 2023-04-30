package com.example.mycontenttrackerbackend.repository.po;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PartnershipPo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID partnershipId;

    private String partnerName;
    private long fee;
}
