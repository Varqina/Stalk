package com.example.Stalk.models.forms;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class AddMessageForm {
    private String message;
    private LocalDateTime creationTime;
}
