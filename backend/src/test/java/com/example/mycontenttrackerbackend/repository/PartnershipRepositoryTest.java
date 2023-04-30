package com.example.mycontenttrackerbackend.repository;

import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
                .fee(12345)
                .build();

        var savedPartnership = partnershipRepository.save(partnership);

        assertThat(savedPartnership).usingRecursiveComparison().isEqualTo(partnership);
    }

    @Test
    public void shouldRetrievePartnershipPoWithId() {
        var partnership = PartnershipPo.builder()
                .partnerName("Partner A")
                .fee(12345)
                .build();

        partnershipRepository.save(partnership);

        var retrievedPartnerships = partnershipRepository.findAll();

        assertNotNull(retrievedPartnerships.get(0).getPartnershipId());
        assertThat(retrievedPartnerships.get(0)).usingRecursiveComparison()
                .ignoringFields("partnershipId")
                .isEqualTo(partnership);
    }
}