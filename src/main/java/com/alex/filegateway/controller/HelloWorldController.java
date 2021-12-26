package com.alex.filegateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex
 */
@RestController
@RequestMapping("test")
public class HelloWorldController {
    @GetMapping("hello")
    public String sayHello() {
        return "Hello World";
    }
}