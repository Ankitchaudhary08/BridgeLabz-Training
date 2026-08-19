package com.ankit.Payroll_App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String designation;



}
