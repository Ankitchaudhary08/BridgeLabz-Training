package com.ankit.Contacts_App.Service;

import com.ankit.Contacts_App.DTO.ContactRequestDto;
import com.ankit.Contacts_App.DTO.ContactResponseDto;
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

    public ContactResponseDto createUser(ContactRequestDto contactRequest){
           Contact contact=new Contact();
           contact.setContactNo(contactRequest.getContactNo());
           contact.setName(contactRequest.getName());
           Contact saveContact=userRepository.save(contact);
        return new ContactResponseDto(saveContact.getId(),
                saveContact.getName(),
                saveContact.getContactNo());
    }

    public ContactResponseDto getByIdContacts(Long id){

        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();

             return new ContactResponseDto(exist.getId(),
                     exist.getName(),
                     exist.getContactNo());}
        throw new ContactNotFoundException("Contact not found with id:"+id);
    }

    public ContactResponseDto updateContact(Long id,ContactRequestDto contact){
        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();
            exist.setName(contact.getName());
            exist.setContactNo(contact.getContactNo());
            Contact contact1= userRepository.save(exist);
             return new ContactResponseDto(contact1.getId(),
                     contact1.getName(),
                     contact1.getContactNo());

        }
        throw new ContactNotFoundException("Contact not found with id:"+id);
    }
}
