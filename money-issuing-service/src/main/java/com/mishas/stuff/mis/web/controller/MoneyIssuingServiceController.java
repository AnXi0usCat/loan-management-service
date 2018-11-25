package com.mishas.stuff.mis.web.controller;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.mis.service.MoneyIssuingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MoneyIssuingServiceController {

    private MoneyIssuingService service;

    @RequestMapping(value = "/api/v1/money", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void issueMoney(@RequestBody @Valid final ApplicationResultDto applicationResultDto) {
        service.issueMoney(applicationResultDto);
    }

    @Autowired
    public void setService(MoneyIssuingService service) {
        this.service = service;
    }
}
