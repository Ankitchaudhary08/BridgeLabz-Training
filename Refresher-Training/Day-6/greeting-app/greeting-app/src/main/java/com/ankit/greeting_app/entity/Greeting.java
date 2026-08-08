package com.ankit.greeting_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="greeting")
public class Greeting {
    public Greeting() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greeting(Long Id, String message){
        this.id=id;
        this.message=message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
