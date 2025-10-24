package org.example.springmentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringMentorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMentorApplication.class, args);
    }

}
