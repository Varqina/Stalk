package com.example.Stalk.models.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class MaintenanceService {

    public void start() throws InterruptedException, IOException {
        Document doc;
        while(true){
            TimeUnit.MINUTES.sleep(5);
            doc = Jsoup.connect("https://secretalk.herokuapp.com/").get();
        }
    }
}
