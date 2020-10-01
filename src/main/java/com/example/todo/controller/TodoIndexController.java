package com.example.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoIndexController {

    private static final Logger logger = LoggerFactory.getLogger(TodoHomeController.class);

    @GetMapping
    public String onLoad() {

        logger.info("Welcome our todo application!");

        return "redirect:/home";
    }

}
