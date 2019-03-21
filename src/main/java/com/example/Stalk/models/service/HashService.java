package com.example.Stalk.models.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HashService {

    public String hashRandom(){
        StringBuilder hash = new StringBuilder();
        Random random = new Random();
        for ( int i = 0; i < 10;i++){
            hash.append(random.nextInt(9));
        }
        return hash.toString();
    }
}
