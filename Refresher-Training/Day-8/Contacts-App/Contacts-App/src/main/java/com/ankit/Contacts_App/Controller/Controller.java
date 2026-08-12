package com.ankit.Contacts_App.Controller;

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
     public Contact createUser(@Valid  @RequestBody Contact contact){
           return  userService.createUser(contact);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Contact> getContact(@PathVariable Long id ){
         Contact getcontact=userService.getByIdContacts(id);
          return ResponseEntity.ok(getcontact);

     }

     @PutMapping("/{id}")
     public ResponseEntity<Contact> updateContact(@PathVariable Long id,@Valid @RequestBody Contact contact1){
          Contact updatedcontact = userService.updateContact(id, contact1);

          return ResponseEntity.ok(updatedcontact);
     }


}
