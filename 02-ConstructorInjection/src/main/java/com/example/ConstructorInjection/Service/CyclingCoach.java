package com.example.ConstructorInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class CyclingCoach implements Coach{


    @Override
    public String getWorkout() {
        return "cycle for 30 mins";
    }
}
