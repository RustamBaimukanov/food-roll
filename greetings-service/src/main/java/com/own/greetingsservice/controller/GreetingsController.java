package com.own.greetingsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping("/greetings")
    public String greetings() {
        return "Hello, World!";
    }
}
