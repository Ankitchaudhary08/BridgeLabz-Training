package com.ankit.Contacts_App.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequestDto {

    @NotBlank(message="name is required")
    @Size(min=2,max=50,message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must contain exactly 10 digits")
    private String contactNo;



}
