package com.ankit.Contacts_App.Mapper;

import com.ankit.Contacts_App.DTO.ContactRequestDto;
import com.ankit.Contacts_App.DTO.ContactResponseDto;
import com.ankit.Contacts_App.Entity.Contact;

public class ContactMapper {

    // DTO → Entity
     public static Contact toEntity(ContactRequestDto dto){
         Contact contact=new Contact();
         contact.setName(dto.getName());
         contact.setContactNo(dto.getContactNo());
         return contact;
     }

    // Entity → Response DTO
    public static ContactResponseDto toResponseDto(Contact contact){
         return new ContactResponseDto(
                 contact.getId(),
                 contact.getName(),
                 contact.getContactNo()
         );
    }



}
