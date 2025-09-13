package com.example.SetterAndFieldInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class RunningCoach implements Coach{

    @Override
    public String getWorkout() {
        return "run everyday for 30 mins";
    }
}
