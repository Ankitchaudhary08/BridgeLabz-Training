package com.ankit.Contacts_App.Service;

import com.ankit.Contacts_App.Entity.Contact;
import com.ankit.Contacts_App.Exception.ContactNotFoundException;
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

    public Contact getByIdContacts(Long id){
        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();
             return exist;}
        throw new ContactNotFoundException("Contact not found with id:"+id);
    }

    public Contact updateContact(Long id,Contact contact){
        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();
            exist.setName(contact.getName());
            exist.setContactNo(contact.getContactNo());
            return userRepository.save(exist);

        }
        throw new ContactNotFoundException("Contact not found with id:"+id);
    }
}
