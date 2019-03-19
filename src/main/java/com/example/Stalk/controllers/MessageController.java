package com.example.Stalk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {


    @GetMapping("/{id}")
    public String displayMessage(@RequestParam("id") String publicKey){



        return "display";
    }
}
