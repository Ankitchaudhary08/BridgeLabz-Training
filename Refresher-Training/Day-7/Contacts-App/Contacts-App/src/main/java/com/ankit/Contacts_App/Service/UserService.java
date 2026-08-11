package com.ankit.Contacts_App.Service;

import com.ankit.Contacts_App.Entity.Contact;
import com.ankit.Contacts_App.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public Contact createUser(Contact contact){
         return userRepository.save(contact);
    }

    public Optional<Contact> getByIdContacts(Long id){
        return userRepository.findById(id);
    }
}
