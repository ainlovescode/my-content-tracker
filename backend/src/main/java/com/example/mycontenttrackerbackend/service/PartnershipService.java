package com.example.mycontenttrackerbackend.service;

import com.example.mycontenttrackerbackend.repository.PartnershipRepository;
import com.example.mycontenttrackerbackend.repository.po.PartnershipPo;
import com.example.mycontenttrackerbackend.service.dto.PartnershipDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnershipService {

    @Autowired
    private PartnershipRepository partnershipRepository;


    ModelMapper modelMapper = new ModelMapper();

    public List<PartnershipDto> getPartnershipsByPartnerName(String partnerName) {
        var retrievedPartnerships = partnershipRepository.findByPartnerName(partnerName);
        return mapToDto(retrievedPartnerships);
    }

    public List<PartnershipDto> mapToDto(List<PartnershipPo> retrievedPartnerships) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return retrievedPartnerships.stream()
                .map(partnershipPo -> modelMapper.map(partnershipPo, PartnershipDto.class))
                .collect(Collectors.toList());
    }
}
