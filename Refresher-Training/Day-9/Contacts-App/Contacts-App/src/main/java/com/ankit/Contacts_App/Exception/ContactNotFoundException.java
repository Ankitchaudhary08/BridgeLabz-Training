package com.ankit.Contacts_App.Exception;

public class ContactNotFoundException extends RuntimeException{
     public ContactNotFoundException(String message){
         super(message);
     }

}
