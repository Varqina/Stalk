package com.example.Stalk.models.repository;


import com.example.Stalk.models.entity.MessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository <MessageEntity,Integer> {

    @Query(value="SELECT * FROM `message` WHERE `public_key` = ?1",nativeQuery = true)
    Optional<MessageEntity> getMessageByPublicKey(String publicKey);

    void delete(Optional<MessageEntity> entity);
}
