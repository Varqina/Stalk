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
    public String getMessage(String publicKey, String privateKey){
        Optional<MessageEntity> entity = messageRepository.getMessageByPublicKey(publicKey);
        String message = "hahahah not this time";
        if( entity.isPresent() && entity.get().getPrivateKey().equals(privateKey)){
            message=entity.get().getMessage();
            messageRepository.delete(entity);
        }
        return message;
    }
    public String generateOutputMessage(Integer id, String key){

        String message="Link:jhasdgfjhdsg/"+id+" activation code = "+key;
        return message;
    }

}
