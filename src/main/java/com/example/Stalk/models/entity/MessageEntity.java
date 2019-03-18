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

    private String key;
    private String message;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
