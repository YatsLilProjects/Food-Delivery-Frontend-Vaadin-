package com.example.application.dto;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DateAndTime {
    LocalTime currentTime = LocalTime.now();
    String greeting;

    public String getGreetingMessage() {
        if (currentTime.isBefore(LocalTime.NOON)) {
            greeting = "Good Morning";
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            greeting = "Good Afternoon";
        } else {
            greeting = "Good Evening";
        }
        return greeting;
    }

}
