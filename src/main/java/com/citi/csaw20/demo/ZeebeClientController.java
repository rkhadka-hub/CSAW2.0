package com.citi.csaw20.demo;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZeebeClientController {
    @Autowired
   ZeebeClient zeebeClient;

    @GetMapping("/start-workflow")
    public String startWorkflow() {
        // Example of starting a workflow
        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("Process_0s0pmjw")
                .latestVersion()
                .send()
                .join();

        return "Workflow started";
    }
}
