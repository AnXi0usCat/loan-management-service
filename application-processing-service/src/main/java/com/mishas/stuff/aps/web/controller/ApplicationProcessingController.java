package com.mishas.stuff.aps.web.controller;

import com.mishas.stuff.aps.service.ApplicationProcessingService;
import com.mishas.stuff.common.web.ApplicationDto;
import com.mishas.stuff.common.web.ApplicationResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ApplicationProcessingController {

    private ApplicationProcessingService service;

    @RequestMapping(value = "/api/v1/application", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ApplicationResultDto processApplication(@RequestBody @Valid final ApplicationDto applicationDto) {
        return service.processApplication(applicationDto);
    }

    @Autowired
    public void setService(ApplicationProcessingService service) {
        this.service = service;
    }
}
