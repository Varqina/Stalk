package com.example.Stalk.models.forms;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class AddMessageForm {
    private Integer id;
    private String message;
    private LocalDateTime creationTime;
}
