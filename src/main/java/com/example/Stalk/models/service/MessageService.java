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



    public void saveMessage(AddMessageForm messageForm){
        MessageEntity entity = new MessageFormToEntityMapper().map(messageForm);
        messageRepository.save(entity);
    }
    public String getMessage(Integer id, String key){
        Optional<MessageEntity> entity = messageRepository.findById(id);
        String message = "hahahah not this time";
        if( entity.isPresent() && entity.get().getKey().equals(key)){
            message=entity.get().getMessage();
        }
        return message;
    }
    public String generateOutputMessage(Integer id, String key){

        String message="Link:jhasdgfjhdsg/"+id+" activation code = "+key;
        return message;
    }

}
