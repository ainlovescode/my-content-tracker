package com.example.mycontenttrackerbackend.controller;

import com.example.mycontenttrackerbackend.service.PartnershipService;
import com.example.mycontenttrackerbackend.service.dto.PartnershipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/partnerships")
public class PartnershipController {

    @Autowired PartnershipService partnershipService;

    @GetMapping
    public ResponseEntity<List<PartnershipDto>> getPartnershipsByName(@RequestBody String partnerName) {

        var allPartnerships = partnershipService.getPartnershipsByPartnerName(partnerName);
        return ResponseEntity.ok(allPartnerships);
    }
}
