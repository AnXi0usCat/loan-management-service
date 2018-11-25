package com.mishas.stuff.aps.web.client;

import com.mishas.stuff.aps.service.ApplicationProcessingService;
import com.mishas.stuff.common.web.ApplicationDto;
import com.mishas.stuff.common.web.ApplicationResultDto;
import org.camunda.bpm.client.ExternalTaskClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class ApplicationProcessingExternalTaskClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationProcessingExternalTaskClient.class.getName());
    private ExternalTaskClient externalTaskClient;
    private ApplicationProcessingService service;

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
                .subscribe ( "processApplication" )
                .handler ((externalTask, externalTaskService) -> {
                    try {
                        // create a DTO
                        ApplicationDto applicationDto = externalTask.getVariable("application");

                        // process the application
                        ApplicationResultDto applicationResult = service.processApplication(applicationDto);

                        externalTaskService.complete(externalTask,
                                Collections.singletonMap("applicationResult", applicationResult));

                    } catch(Exception e) {
                        LOGGER.error("Camunda Error Occured: " + e.getMessage());
                        // If an error occurs, it should be reported back to the Process Engine (gives an incident)
                        externalTaskService.handleFailure(externalTask, " Application Processing Error" , e.getLocalizedMessage(), 0 , 1 );
                    }
                }).open();
    }
    @Autowired
    public void setService(ApplicationProcessingService service) {
        this.service = service;
    }

}
