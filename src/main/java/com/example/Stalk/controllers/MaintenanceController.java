package com.example.Stalk.controllers;

import com.example.Stalk.models.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/keepmain")
    public void startMaintenance(){
        try {
            maintenanceService.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
