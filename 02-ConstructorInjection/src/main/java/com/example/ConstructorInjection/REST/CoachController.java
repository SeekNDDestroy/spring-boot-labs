package com.example.ConstructorInjection.REST;

import com.example.ConstructorInjection.Service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    //below spring knows which beans to inject since the defaut naming of beans match the field names
    private Coach swimmingCoach; //alternate SwimmingCoach swimmingCoach
    private Coach runningCoach; //alternate RunningCoach runningCoach

    private Coach coach; // bean will be injected using @Qualifier




    public CoachController(Coach swimmingCoach,
                           Coach runningCoach,
                           @Qualifier("cyclingCoach")Coach coach){
        this.swimmingCoach = swimmingCoach;
        this.runningCoach = runningCoach;
        this.coach = coach;
    }

    @GetMapping("/swimming")
    public String getSwimmingWorkout(){
        return "<h1>" + this.swimmingCoach.getWorkout() + "</h1>";
    }

    @GetMapping("/running")
    public String getRunningWorkout(){
        return "<h1>" + this.runningCoach.getWorkout() + "</h1>";
    }

    @GetMapping("/cycling")
    public String getCyclingWorkout(){
        return "<h1>" + this.coach.getWorkout() + "</h1>";
    }
}
