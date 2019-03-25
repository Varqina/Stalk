package com.example.Stalk.models.service;

import com.example.Stalk.models.entity.MessageEntity;
import com.example.Stalk.models.forms.AddMessageForm;
import com.example.Stalk.models.mapper.MessageFormToEntityMapper;
import com.example.Stalk.models.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;



    public void saveMessage(AddMessageForm messageForm, String publicKey, String privateKey){
        MessageEntity entity = new MessageFormToEntityMapper().map(messageForm);
        entity.setPrivateKey(privateKey);
        entity.setPublicKey(publicKey);
        messageRepository.save(entity);
    }
    public String getMessage(String publicKey, String privateKey){
        Optional<MessageEntity> entity = messageRepository.getMessageByPublicKey(publicKey);
        String message = "hahahah not this time";
        if( entity.isPresent() && entity.get().getPrivateKey().equals(privateKey)){
            message=entity.get().getMessage();
            messageRepository.deleteById(entity.get().getId());
        }
        return message;
    }
    public String generateOutputMessage(String publicKey, String privateKey){

//        String message="<a href=https://secretalk.herokuapp.com/"+publicKey+">https://secretalk.herokuapp.com/"+publicKey+"</a> " +
//                "code = "+privateKey;
        String message = "https://secretalk.herokuapp.com/key/"+publicKey+"  Activation code:"+ privateKey;
        return message;
    }
}
