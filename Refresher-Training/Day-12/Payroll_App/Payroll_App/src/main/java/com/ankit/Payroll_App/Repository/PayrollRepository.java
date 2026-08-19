package com.ankit.Payroll_App.Repository;

import com.ankit.Payroll_App.Entity.Employee;
import com.ankit.Payroll_App.Entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll,Long> {
}
