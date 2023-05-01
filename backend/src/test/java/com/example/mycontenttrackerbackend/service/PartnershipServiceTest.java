package com.example.mycontenttrackerbackend.service;

import com.example.mycontenttrackerbackend.factory.PartnershipFactory;
import com.example.mycontenttrackerbackend.repository.PartnershipRepository;
import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static com.example.mycontenttrackerbackend.factory.PartnershipFactory.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PartnershipServiceTest {

    @Mock
    private PartnershipRepository partnershipRepository;

    @InjectMocks
    private PartnershipService partnershipService;

    @Test
    public void savePartnership() {
        var partnership = PartnershipFactory.valid();

        var savedPartnershipPo = valid();

        when(partnershipRepository.save((PartnershipPo) any(PartnershipPo.class)))
                .thenReturn(savedPartnershipPo);

        var savedPartnership = partnershipService.savePartnership(partnership);

        assertNotNull(savedPartnership);
        assertEquals(PARTNER_A_NAME, savedPartnership.getPartnerName());
        assertEquals(PARTNERSHIP_FEE, savedPartnership.getPartnershipFee());
    }
    @Test
    public void getPartnershipDtoByPartnerName() {
        var partnershipsByA = List.of(PartnershipPo.builder()
                .partnerName("Partner A")
                .partnershipFee(250)
                .partnershipId(UUID.randomUUID())
                .build());

        when(partnershipRepository.findByPartnerName("Partner A"))
                .thenReturn((List<PartnershipPo>) partnershipsByA);

        var partnershipsByAFromService = partnershipService.getPartnershipsByPartnerName("Partner A");

        assertEquals(1, partnershipsByAFromService.size());
        assertEquals("Partner A", partnershipsByAFromService.get(0).getPartnerName());
    }
}