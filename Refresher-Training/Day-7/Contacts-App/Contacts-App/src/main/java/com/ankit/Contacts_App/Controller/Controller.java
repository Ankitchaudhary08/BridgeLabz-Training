package com.ankit.Contacts_App.Controller;

import com.ankit.Contacts_App.Entity.Contact;
import com.ankit.Contacts_App.Service.UserService;
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
     public Contact createUser(@RequestBody Contact contact){
           return  userService.createUser(contact);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Contact> getContact(@PathVariable Long id ){
           Optional<Contact> contact=userService.getByIdContacts(id);
          if (contact.isPresent()) {
               return ResponseEntity.ok(contact.get());
          }

          return ResponseEntity.notFound().build();

     }


}
