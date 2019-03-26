package com.example.Stalk.models.service;

import com.example.Stalk.models.entity.MessageEntity;
import com.example.Stalk.models.repository.MessageRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class MaintenanceService {

    @Autowired
    MessageRepository messageRepository;

    public void start() throws InterruptedException, IOException {
        Document doc;
        int counter =0;
        while(true){
            clearDataBase();
            TimeUnit.MINUTES.sleep(1);
            counter++;
            if(counter==5){
                doc = Jsoup.connect("https://secretalk.herokuapp.com/").get();
                counter=0;
            }
        }
    }
    public void clearDataBase(){
        List temp=messageRepository.getIdFromDataBase();
        if(temp.size()>0){
            for (int i=0;i<temp.size();i++){
                Optional<MessageEntity> entity=messageRepository.getMessageById(temp.indexOf(i));
                if(entity.isPresent()){
                    deleteIfExpired(entity,i);
                }
            }
        }
    }
    public void deleteIfExpired(Optional<MessageEntity> entity,Integer id){
        String data=entity.get().getCreationTime().toString();
        String actualData= LocalDateTime.now().toString();
        Integer creationTimeInteger=(Integer.parseInt(data.substring(11,13))*60)+Integer.parseInt(data.substring(14,16));
        Integer actualTimeInteger=(Integer.parseInt(actualData.substring(11,13))*60)+Integer.parseInt(actualData.substring(14,16));
        if(actualTimeInteger-creationTimeInteger>15){
            messageRepository.deleteById(id);
        }
    }
}
