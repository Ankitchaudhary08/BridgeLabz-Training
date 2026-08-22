package com.ankit.Fundoo_Notes_App.Service;

import com.ankit.Fundoo_Notes_App.Entity.User;
import com.ankit.Fundoo_Notes_App.Repository.UserRepository;
import com.ankit.Fundoo_Notes_App.Security.JwtService;
import com.ankit.Fundoo_Notes_App.Security.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,JwtService jwtService){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtService=jwtService;
    }

    public User registerUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("email already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    public String login(String email,String password){

        System.out.println("LOGIN METHOD CALLED");
        User user=userRepository
                .findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return jwtService.generateToken(user.getEmail());
    }

}
