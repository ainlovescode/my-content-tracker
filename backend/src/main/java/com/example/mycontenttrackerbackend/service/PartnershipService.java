package com.example.mycontenttrackerbackend.service;

import com.example.mycontenttrackerbackend.repository.PartnershipRepository;
import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import com.example.mycontenttrackerbackend.service.dto.PartnershipDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnershipService {

    @Autowired private PartnershipRepository partnershipRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public PartnershipDto savePartnership(PartnershipPo partnershipDetails) {
        var savedPartnership = partnershipRepository.save(partnershipDetails);

        var partnershipDto = mapToDto(savedPartnership);
        return partnershipDto;
    }

    public List<PartnershipDto> getPartnershipsByPartnerName(String partnerName) {
        var retrievedPartnerships = partnershipRepository.findByPartnerName(partnerName);

        var partnershipsToDto =
                retrievedPartnerships.stream()
                        .map(partnershipPo -> mapToDto(partnershipPo))
                        .collect(Collectors.toList());

        return partnershipsToDto;
    }

    public List<PartnershipDto> getAllPartnerships() {
        var retrievedPartnerships = partnershipRepository.findAllByOrderByPartnerNameAsc();
        var partnershipsToDto =
                retrievedPartnerships.stream()
                        .map(partnershipPo -> mapToDto(partnershipPo))
                        .collect(Collectors.toList());

        return partnershipsToDto;
    }

    public PartnershipDto mapToDto(PartnershipPo partnershipPo) {

        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return modelMapper.map(partnershipPo, PartnershipDto.class);
    }
}
