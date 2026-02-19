package com.example.Testing1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerClass {


    @GetMapping("/getMessage")
    public String getMessage() {
        return "Hello Welcom";
    }

    @GetMapping("/getMessage1")
    public String getMessage1() {
        return "This is the New Method";
    }
}
