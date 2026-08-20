package com.ankit.Fundoo_Notes_App.Controller;

import com.ankit.Fundoo_Notes_App.Entity.User;
import com.ankit.Fundoo_Notes_App.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping ("/register")
        public ResponseEntity<User> registerUser(@RequestBody User user){
        return new ResponseEntity<>(authService.registerUser(user), HttpStatus.CREATED);
        }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody User user){
        String token=authService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(Map.of("token",token));


    }

    @GetMapping("/test")
    public String test() {
        return "You are authenticated";
    }

}
