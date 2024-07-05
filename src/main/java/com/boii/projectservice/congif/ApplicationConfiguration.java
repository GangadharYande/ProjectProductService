package com.boii.projectservice.congif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate getRestTemplateBean() {

        /* Some Hypothetical Scenario


            @Bean
            *  RestTemplate restTemplate;


           * int noOfRequest =100;
           int timeOut = 1;
           boolean shouldAuthenticate = true;
           return new RestTemplate ( noOfRequest,timeOut,shouldAuthenticate);

         */

        return new RestTemplate();
    }
}
