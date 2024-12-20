package com.example.book.controller;

import org.springframework.stereotype.Controller;

import groovy.util.logging.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

}
