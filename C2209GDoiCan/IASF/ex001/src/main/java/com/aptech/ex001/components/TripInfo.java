package com.aptech.ex001.components;

import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.stereotype.Component;
//create a custom component
/*
How to create a "global" TripInfo object ?
* */

@Component
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@Data
public class TripInfo { //POJO class = Plain Object JAva Object

    private String tripName;
    private String destination;
    public TripInfo() {
        this.tripName = "Camping Trip";
        this.destination = "Yellowstone National Park";
    }
    @PostConstruct
    public void postContruct() {
        System.out.println("postContruct");
    }
}
