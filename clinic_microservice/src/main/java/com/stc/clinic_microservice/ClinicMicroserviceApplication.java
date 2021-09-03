package com.stc.clinic_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClinicMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicMicroserviceApplication.class, args);
    }

}
