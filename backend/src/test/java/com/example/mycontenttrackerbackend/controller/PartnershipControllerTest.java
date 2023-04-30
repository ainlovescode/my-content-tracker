package com.example.mycontenttrackerbackend.controller;

import com.example.mycontenttrackerbackend.service.PartnershipService;
import com.example.mycontenttrackerbackend.service.dto.PartnershipDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static com.example.mycontenttrackerbackend.factory.PartnershipFactory.PARTNER_A_NAME;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PartnershipController.class)
class PartnershipControllerTest {

    @MockBean
    PartnershipService partnershipService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllPartnerships() throws Exception {

        var allPartnerships = List.of(
                PartnershipDto.builder().partnershipId(UUID.randomUUID())
                        .fee(500)
                        .partnerName(PARTNER_A_NAME)
                        .build()
        );

        when(partnershipService.getPartnershipsByPartnerName(PARTNER_A_NAME)).thenReturn((List<PartnershipDto>) allPartnerships);

        mockMvc.perform(get("/partnerships").content(PARTNER_A_NAME))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].partnerName").value(PARTNER_A_NAME));


    }
}