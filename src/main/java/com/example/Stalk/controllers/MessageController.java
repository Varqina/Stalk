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

    @GetMapping("/key/{key}")
    public String getPrivateKey(Model model,@PathVariable("key") String publicKey){
        model.addAttribute("public",publicKey);
        return "public";
    }
    @ResponseBody
    @PostMapping("/getMessage")
    public String displayMessage(@RequestParam("public") String publicKey   , @RequestParam("code") String privateKey, Model model){
        return messageService.getMessage(publicKey,privateKey);
       }
    @GetMapping("/")
    public String prepareMessage(Model model){
        model.addAttribute("message_content", new AddMessageForm());
        return "new";
    }
    @PostMapping("/")
    public String createNewMessage(@ModelAttribute AddMessageForm message, Model model){
        String publicKey=hashService.hashRandom();
        String privateKey=hashService.hashRandom();
        model.addAttribute("message_content", new AddMessageForm());
        messageService.saveMessage(message,publicKey,privateKey);
        model.addAttribute("activation_code",messageService.generateOutputMessage(publicKey,privateKey));
        return "new";
    }


}
