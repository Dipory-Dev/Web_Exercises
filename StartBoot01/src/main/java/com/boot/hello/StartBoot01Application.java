package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class StartBoot01Application {

    public static void main(String[] args) {
        SpringApplication.run(StartBoot01Application.class, args);
    }

    @GetMapping("/index")
    public String root() {
        return "test";
    }

}
