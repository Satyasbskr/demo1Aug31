package com.example.demo1aug31;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloControler {

    @RequestMapping("/greeting")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
