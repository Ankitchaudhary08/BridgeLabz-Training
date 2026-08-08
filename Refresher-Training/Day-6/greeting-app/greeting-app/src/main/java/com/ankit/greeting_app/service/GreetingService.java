package com.ankit.greeting_app.service;

import com.ankit.greeting_app.entity.Greeting;

import java.util.List;

public interface GreetingService {

    Greeting createGreeting(Greeting greeting);

    List<Greeting> getAllGreeting();

    Greeting updateGreeting(Long Id,String message);

    Greeting getGreetingById(Long Id);
    void deleteGreetingById(Long Id);

}
