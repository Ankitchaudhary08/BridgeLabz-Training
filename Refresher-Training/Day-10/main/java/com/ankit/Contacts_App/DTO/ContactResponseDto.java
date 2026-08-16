package com.ankit.Contacts_App.DTO;

import lombok.Getter;

@Getter
public class ContactResponseDto {
    private Long id;
    private String name;
    private String contactNo;
    public ContactResponseDto(Long id,String name,String contactNo){
        this.id=id;
        this.name=name;
        this.contactNo=contactNo;
    }



}
