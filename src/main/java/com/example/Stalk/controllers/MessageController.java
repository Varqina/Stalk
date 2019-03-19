package com.example.Stalk.controllers;

import com.example.Stalk.models.forms.AddMessageForm;
import com.example.Stalk.models.service.HashService;
import com.example.Stalk.models.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    HashService hashService;

    @GetMapping("/{id}")
    public String getPrivateKey(Model model, @RequestParam("id") String publicKey){
        model.addAttribute("id",publicKey);
        return "public";
    }
    @PostMapping("/{id}")
    public String displayMessage(@RequestParam("id") String publicKey, @ModelAttribute("private_key") String privateKey, Model model){
        model.addAttribute("message",messageService.getMessage(publicKey,privateKey));
        return "private";
    }
    @GetMapping("/new")
    public String prepareMessage(Model model){
        model.addAttribute("message_content", new AddMessageForm());
        return "new";
    }
    @PostMapping("/new")
    @ResponseBody
    public String createNewMessage(@ModelAttribute AddMessageForm message){
        String publicKey=hashService.hashRandom();
        String privateKey=hashService.hashRandom();
        messageService.saveMessage(message,publicKey,privateKey);
        return messageService.generateOutputMessage(publicKey,privateKey);
    }
}
