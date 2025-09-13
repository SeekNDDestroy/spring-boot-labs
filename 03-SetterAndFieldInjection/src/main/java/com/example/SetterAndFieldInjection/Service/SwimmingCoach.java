package com.example.SetterAndFieldInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{

    @Override
    public String getWorkout() {
        return "swim everyday for 25 mins";
    }
}
