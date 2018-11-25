package com.mishas.stuff.acs.service.impl;

import com.mishas.stuff.acs.service.ApplicationCreationService;
import com.mishas.stuff.common.web.ApplicationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
public class ApplicationCreationServiceImpl implements ApplicationCreationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationCreationService.class.getName());

    @Override
    public ApplicationDto createApplication(String firstname, String surname, Integer loanAmount) {
        String UUID = generateUUID(firstname, surname, loanAmount);
        logger.info("creating new application");
        return new ApplicationDto(UUID, firstname, surname, loanAmount);
    }

    private String generateUUID(String firstname, String surname, Integer loanAmount) {
        byte[] bytes;
        String source = firstname + surname + loanAmount;
        try {
            bytes = source.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ue) {
            logger.error("Failed to convert application instance to Bytes");
            throw new RuntimeException("Could not convert ApplicationDto to bytes: " +ue.getMessage());
        }
        String uuid = UUID.nameUUIDFromBytes(bytes).toString();
        logger.info("uuid generated: "+ uuid);
        return uuid;
    }
}
