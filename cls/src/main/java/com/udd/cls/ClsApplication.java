package com.udd.cls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class ClsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClsApplication.class, args);
	}

    // @Bean
    // ApplicationRunner applicationRunner(Environment environment) {
    //     return args -> {
    //         System.out.println("message from application.properties " + environment.getProperty("minio.host"));
    //     };
    // }

}
