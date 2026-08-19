package com.ankit.Payroll_App.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Payroll")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employee_id;
    private String month;
    private int grossSalary;
    private int deduction;
    private int netSalary;

}
