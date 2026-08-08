package com.ankit.greeting_app.service;


import com.ankit.greeting_app.entity.Greeting;
import com.ankit.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository){
        this.greetingRepository=greetingRepository;
    }

    public Greeting createGreeting( Greeting greeting){
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreeting(){
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id,String message){
        Greeting existingGreeting = greetingRepository.findById(id)
               .orElseThrow(() ->
                new RuntimeException("Greeting not found with id: " + id));

        existingGreeting.setMessage(message);

        return greetingRepository.save(existingGreeting);
    }
    public void deleteGreetingById(Long id) {

        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Greeting not found with id: " + id));

        greetingRepository.delete(existingGreeting);
    }

    public Greeting getGreetingById(Long id){
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Greeting not found with id: " + id));
        return existingGreeting;
    }



}
