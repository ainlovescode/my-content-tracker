package com.example.mycontenttrackerbackend.repository;

import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class PartnershipRepositoryTest {

    @Autowired
    private PartnershipRepository partnershipRepository;


    @AfterEach
    void tearDown() {
        partnershipRepository.deleteAll();
    }

    @Test
    public void shouldSaveValidPartnershipPo() {
        var partnership = PartnershipPo.builder()
                .partnerName("Partner A")
                .partnershipFee(12345)
                .build();

        var savedPartnership = partnershipRepository.save(partnership);

        assertThat(savedPartnership).usingRecursiveComparison().isEqualTo(partnership);
    }

    @Test
    public void shouldRetrievePartnershipPoGivenPartnerName() {
        var partnership = PartnershipPo.builder()
                .partnerName("Partner A")
                .partnershipFee(12345)
                .build();

        partnershipRepository.save(partnership);

        var retrievedPartnerships = partnershipRepository.findByPartnerName("Partner A");

        assertEquals(1, retrievedPartnerships.size());
        assertNotNull(retrievedPartnerships.get(0).getPartnerName());
    }
}