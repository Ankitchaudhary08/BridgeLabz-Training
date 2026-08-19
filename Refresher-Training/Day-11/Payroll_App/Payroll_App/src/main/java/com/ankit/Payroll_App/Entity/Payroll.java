package com.ankit.Payroll_App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private Long id;
    private Long employee_id;
    private String month;
    private int grossSalary;
    private int deduction;
    private int netSalary;

}
