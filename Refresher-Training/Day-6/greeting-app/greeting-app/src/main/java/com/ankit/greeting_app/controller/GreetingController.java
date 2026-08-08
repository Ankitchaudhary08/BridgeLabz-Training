package com.ankit.greeting_app.controller;

import com.ankit.greeting_app.entity.Greeting;
import com.ankit.greeting_app.service.GreetingService;
import com.ankit.greeting_app.service.GreetingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/greetings")
@RestController
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService=greetingService;
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting){
        return greetingService.createGreeting(greeting);
    }

    @GetMapping
    public List<Greeting> getAllGreeting(){
        return greetingService.getAllGreeting();
    }

    @GetMapping("/id")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    @PutMapping("/id")
    public Greeting updateGreeting(@PathVariable Long id,@RequestBody String message){
        return greetingService.updateGreeting(id,message);
    }

    @DeleteMapping("/Id")
    public void deleteGreetingById(@PathVariable Long id){
         greetingService.deleteGreetingById(id);
    }


}
