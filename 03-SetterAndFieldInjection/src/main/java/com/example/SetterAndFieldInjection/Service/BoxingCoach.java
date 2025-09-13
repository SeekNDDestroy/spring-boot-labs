package com.example.SetterAndFieldInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach{
    @Override
    public String getWorkout() {
        return "box everyday for 45 mins";
    }
}
