package com.udd.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Slf4j
public class ProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectApplication.class, args);
<<<<<<< HEAD
    // log.info("STATISTIC-LOG serveFile -> ");
    // System.out.println("Project started");
=======
    //log.info("STATISTIC-LOG serveFile -> ");
    //System.out.println("Project started");
>>>>>>> a13e7b2 (test)
  }

}

@RestController
class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
