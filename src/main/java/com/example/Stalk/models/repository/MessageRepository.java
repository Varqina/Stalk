package com.example.Stalk.models.repository;


import com.example.Stalk.models.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository <MessageEntity,Integer> {

}
