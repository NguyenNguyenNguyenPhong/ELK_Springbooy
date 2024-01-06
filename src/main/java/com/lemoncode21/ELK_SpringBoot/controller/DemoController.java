package com.lemoncode21.ELK_SpringBoot.controller;//package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

public class DemoController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public String hello() {
        logger.info("Hello endpoint is accessed!");
        return "Hello, World!";
    }
}
