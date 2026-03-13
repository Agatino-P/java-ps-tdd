package com.example.api.controllers.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping()
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("get-string")
    public String getMethodName(@RequestParam String inputString) {
        return inputString;
    }
    
}
