package com.agatino.api.controllers.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping()
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/get-string")
    public String getMethodName(@RequestParam String param) {
        return "Hello, " + param;
    }
}
