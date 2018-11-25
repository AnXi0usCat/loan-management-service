package com.mishas.stuff.lcs.web.client;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.common.web.LoanDto;
import com.mishas.stuff.lcs.service.LoanIssuingService;
import org.camunda.bpm.client.ExternalTaskClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class LoanIssuingExternalTaskClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoanIssuingExternalTaskClient.class.getName());
    private ExternalTaskClient externalTaskClient;
    private LoanIssuingService service;

    @PostConstruct
    private void init() {

        externalTaskClient =  ExternalTaskClient
                .create() // Initiate the ExternalTaskClientBuilder
                .baseUrl("http://camunda-engine:8080/engine-rest") // URL of the REST API of the Process Engine
                .maxTasks(1)
      		.asyncResponseTimeout(120000)
		.lockDuration( 1000 ) // Long polling for 10 seconds (10000 milliseconds)
                .build();

        externalTaskClient
                .subscribe ( "createLoan" )
                .handler ((externalTask, externalTaskService) -> {
                    try {
                        // create a DTO
                        ApplicationResultDto applicatioResultDto = externalTask.getVariable("applicationResult");

                        // process the application
                        LoanDto loan = service.createLoan(applicatioResultDto);

                        externalTaskService.complete(externalTask,
                                Collections.singletonMap("loan", loan));

                    } catch(Exception e) {
                        LOGGER.error("Camunda Error Occured: " + e.getMessage());
                        // If an error occurs, it should be reported back to the Process Engine (gives an incident)
                        externalTaskService.handleFailure(externalTask, " Application Processing Error" , e.getLocalizedMessage(), 0 , 1 );
                    }
                }).open();
    }

    @Autowired
    public void setService(LoanIssuingService service) {
        this.service = service;
    }
}
