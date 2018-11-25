package com.mishas.stuff.aps.service;

import com.mishas.stuff.common.web.ApplicationDto;
import com.mishas.stuff.common.web.ApplicationResultDto;

public interface ApplicationProcessingService {

    ApplicationResultDto processApplication(ApplicationDto applicationDto);
}
