package com.example.mycontenttrackerbackend.controller;

import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import com.example.mycontenttrackerbackend.service.PartnershipService;
import com.example.mycontenttrackerbackend.service.dto.PartnershipDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partnerships")
public class PartnershipController {

    @Autowired PartnershipService partnershipService;

    @PostMapping
    public ResponseEntity<PartnershipDto> createNewPartnership(
            @RequestBody PartnershipPo partnershipDetails) {

        var savedPartnership = partnershipService.savePartnership(partnershipDetails);
        return ResponseEntity.ok(savedPartnership);
    }

    @GetMapping(path = "/{partnerName}")
    public ResponseEntity<List<PartnershipDto>> getPartnershipsByPartnerName(
            @PathVariable String partnerName) {

        var allPartnerships = partnershipService.getPartnershipsByPartnerName(partnerName);
        System.out.println("PARTNER NAME: " + allPartnerships.toString());
        return ResponseEntity.ok(allPartnerships);
    }

    @GetMapping
    public ResponseEntity<List<PartnershipDto>> getAllPartnerships() {
        var allPartnerships = partnershipService.getAllPartnerships();
        return ResponseEntity.ok(allPartnerships);
    }
}
