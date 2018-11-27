package com.mishas.stuff.acs.web.client;

import com.mishas.stuff.acs.service.ApplicationCreationService;
import com.mishas.stuff.common.web.ApplicationDto;
import org.camunda.bpm.client.ExternalTaskClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Collections;

import static org.camunda.spin.Spin.JSON;

@Component
public class ApplicationCreationExternalTaskClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationCreationExternalTaskClient.class.getName());
    private ExternalTaskClient externalTaskClient;
    private ApplicationCreationService service;

    @PostConstruct
    private void init() {
        // "http://172.17.0.2:8080/engine-rest"
        externalTaskClient =  ExternalTaskClient
                .create() // Initiate the ExternalTaskClientBuilder
                .baseUrl("http://camunda-engine:8080/engine-rest") // URL of the REST API of the Process Engine
                .maxTasks(1)
                .asyncResponseTimeout(120000)
                .lockDuration( 1000 ) // Long polling for 10 seconds (10000 milliseconds)
                .build();

        externalTaskClient
                .subscribe ( "createApplication" )
                .handler ((externalTask, externalTaskService) -> {
                    try {
                        // process the application
                        ApplicationDto applicationDto = service.createApplication(
                                externalTask.getVariable("firstname"),
                                externalTask.getVariable("surname"),
                                externalTask.getVariable("loanAmount")
                        );
                        externalTaskService.complete(externalTask,
                                Collections.singletonMap("application", JSON(applicationDto).toString())
                        );

                    } catch(Exception e) {
                        LOGGER.error("Camunda Error Occured: " + e.getMessage());
                        // If an error occurs, it should be reported back to the Process Engine (gives an incident)
                        externalTaskService.handleFailure(externalTask, " Application Creating Error" , e.getLocalizedMessage(), 0 , 1 );
                    }
                }).open();
    }
    @Autowired
    public void setService(ApplicationCreationService service) {
        this.service = service;
    }

}