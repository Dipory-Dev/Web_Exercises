package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SpringBoot02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02Application.class, args);
    }

    @RequestMapping("/")
    public String root() {
        return "index";
    }
}
