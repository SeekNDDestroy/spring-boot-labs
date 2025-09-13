package com.example.SetterAndFieldInjection.Rest;


import com.example.SetterAndFieldInjection.Service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach coachOne;
    private Coach coachTwo;

    @Autowired
    @Qualifier("boxingCoach")
    private Coach coachThree;


    @Autowired
    @Qualifier("runningCoach")
    public void setCoachOne(Coach coach){
        this.coachOne = coach;
    }

    @Autowired
    @Qualifier("swimmingCoach")
    public void setCoachTwo(Coach coach){
        this.coachTwo = coach;
    }

    @GetMapping("/running")
    public String running(){
        return this.coachOne.getWorkout();
    }

    @GetMapping("/swimming")
    public String swimming(){
        return this.coachTwo.getWorkout();
    }

    @GetMapping("/boxing")
    public String boxing(){
        return this.coachThree.getWorkout();
    }

}
