package com.example.ConstructorInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{
    
    @Override
    public String getWorkout() {
        return "practice swimming for 45 mins.";
    }
}
