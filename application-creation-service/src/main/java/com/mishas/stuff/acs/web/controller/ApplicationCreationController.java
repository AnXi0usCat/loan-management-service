package com.mishas.stuff.acs.web.controller;

import com.mishas.stuff.acs.service.ApplicationCreationService;
import com.mishas.stuff.common.web.ApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationCreationController {

    private ApplicationCreationService service;

    @RequestMapping(value = "/api/v1/application", method = RequestMethod.GET)
    @ResponseBody
    public ApplicationDto createApplication(
            @RequestParam(value = "firstname") final String firstname,
            @RequestParam(value = "surname") final String surname,
            @RequestParam(value = "loanAmount") final Integer loanAmount
    ) {
        return service.createApplication(firstname, surname, loanAmount);
    }

    @Autowired
    public void setService(ApplicationCreationService service) {
        this.service = service;
    }
}
