package com.example.mycontenttrackerbackend.repository;

import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartnershipRepository extends JpaRepository<PartnershipPo, UUID> {
    List<PartnershipPo> findByPartnerName(String partnerName);
}
