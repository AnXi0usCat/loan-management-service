package com.mishas.stuff.lcs.web.controller;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.common.web.LoanDto;
import com.mishas.stuff.lcs.service.LoanIssuingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoanCreationController {

    private LoanIssuingService service;

    @RequestMapping(value = "/api/v1/loan", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public LoanDto createLoan(@RequestBody @Valid final ApplicationResultDto applicatioResultDto) {
        return service.createLoan(applicatioResultDto);
    }

    @Autowired
    public void setService(LoanIssuingService service) {
        this.service = service;
    }
}
