package com.ankit.Contacts_App.Controller;

import com.ankit.Contacts_App.DTO.ContactRequestDto;
import com.ankit.Contacts_App.DTO.ContactResponseDto;
import com.ankit.Contacts_App.Entity.Contact;
import com.ankit.Contacts_App.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class Controller {
     private final UserService userService;

     public Controller(UserService userService){
          this.userService=userService;
     }

     @PostMapping("/create")
     public ContactResponseDto createUser(@Valid  @RequestBody ContactRequestDto contact){

          return  userService.createUser(contact);
     }

     @GetMapping("/{id}")
     public ResponseEntity<ContactResponseDto> getContact(@PathVariable Long id ){
         ContactResponseDto getcontact=userService.getByIdContacts(id);
          return ResponseEntity.ok(getcontact);

     }

     @PutMapping("/{id}")
     public ResponseEntity<ContactResponseDto> updateContact(@PathVariable Long id,@Valid @RequestBody ContactRequestDto contact1){
          ContactResponseDto updatedcontact = userService.updateContact(id, contact1);

          return ResponseEntity.ok(updatedcontact);
     }


}
