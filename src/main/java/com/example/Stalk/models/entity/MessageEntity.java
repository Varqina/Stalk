package com.example.Stalk.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="message")
@Entity
@Data
public class MessageEntity {
    @Id @GeneratedValue
    private Integer id;

    @Column(name = "private_key")
    private String privateKey;
    @Column(name = "public_key")
    private String publicKey;

    private String message;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
