package com.example.ConstructorInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class RunningCoach implements Coach{

    @Override
    public String getWorkout() {
        return "practice running for 30 mins";
    }
}
