package com.mishas.stuff.acs.service;

import com.mishas.stuff.common.web.ApplicationDto;

public interface ApplicationCreationService {

    ApplicationDto createApplication(String firstname, String surname, Integer loanAmount);
}
