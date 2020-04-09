package com.edu.zafu.subjectbuildappmonitoring;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SubjectBuildAppMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectBuildAppMonitoringApplication.class, args);
    }

}
