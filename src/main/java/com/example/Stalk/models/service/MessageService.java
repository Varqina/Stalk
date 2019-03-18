package com.example.Stalk.models.service;

import com.example.Stalk.models.entity.MessageEntity;
import com.example.Stalk.models.forms.AddMessageForm;
import com.example.Stalk.models.mapper.MessageFormToEntityMapper;
import com.example.Stalk.models.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;



    public void saveMessage(AddMessageForm messageForm){
        MessageEntity entity = new MessageFormToEntityMapper().map(messageForm);
        messageRepository.save(entity);
    }
}
