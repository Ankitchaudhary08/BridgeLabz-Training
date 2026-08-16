package com.ankit.Contacts_App.Service;

import com.ankit.Contacts_App.DTO.ContactRequestDto;
import com.ankit.Contacts_App.DTO.ContactResponseDto;
import com.ankit.Contacts_App.Entity.Contact;
import com.ankit.Contacts_App.Exception.ContactNotFoundException;
import com.ankit.Contacts_App.Mapper.ContactMapper;
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
        Contact contact = ContactMapper.toEntity(contactRequest);
           Contact saveContact=userRepository.save(contact);
        return  ContactMapper.toResponseDto(saveContact);
    }

    public ContactResponseDto getByIdContacts(Long id){

        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();

             return ContactMapper.toResponseDto(exist);}
        throw new ContactNotFoundException("Contact not found with id:"+id);
    }

    public ContactResponseDto updateContact(Long id,ContactRequestDto contact){
        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();
            exist.setName(contact.getName());
            exist.setContactNo(contact.getContactNo());
            Contact contact1= userRepository.save(exist);
             return ContactMapper.toResponseDto(contact1);

        }
        throw new ContactNotFoundException("Contact not found with id:"+id);
    }

    public ContactResponseDto deleteContact(Long id){
        Optional<Contact> existingContact=userRepository.findById(id);
        if(existingContact.isPresent()){
            Contact exist=existingContact.get();
           userRepository.delete(exist);
           return ContactMapper.toResponseDto(exist);
        }
        throw new ContactNotFoundException("Contact not found with id:"+id);

    }
}
