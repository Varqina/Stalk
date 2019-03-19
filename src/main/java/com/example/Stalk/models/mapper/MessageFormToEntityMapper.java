package com.example.Stalk.models.mapper;


import com.example.Stalk.models.entity.MessageEntity;
import com.example.Stalk.models.forms.AddMessageForm;
import com.example.Stalk.models.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageFormToEntityMapper {

    @Autowired
    HashService hashService;

    public MessageEntity map(AddMessageForm form) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(form.getMessage());
        messageEntity.setPublicKey(hashService.hashRandom());
        messageEntity.setPrivateKey(hashService.hashRandom());
        return messageEntity;
    }
}
